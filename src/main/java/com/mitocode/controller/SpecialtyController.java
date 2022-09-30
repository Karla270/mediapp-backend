package com.mitocode.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.mitocode.dto.SpecialtyDTO;
import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Specialty;
import com.mitocode.service.ISpecialtyService;


@RestController
@RequestMapping("/specialties")
public class SpecialtyController {

	@Autowired
	private ISpecialtyService service;

	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<List<SpecialtyDTO>> findAll() {
		List<SpecialtyDTO> list = service.findAll().stream().map(p -> mapper.map(p, SpecialtyDTO.class))
				.collect(Collectors.toList());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

    @GetMapping("/{id}")
    public ResponseEntity<SpecialtyDTO> findById(@PathVariable("id") Integer id) {
        SpecialtyDTO dtoResponse;
        Specialty obj = service.findById(id);
        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        } else {
            dtoResponse = mapper.map(obj, SpecialtyDTO.class);
        }
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody SpecialtyDTO dto) {
		Specialty p = service.save(mapper.map(dto, Specialty.class));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdSpecialty())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Specialty> update(@Valid @RequestBody SpecialtyDTO dto) {
		Specialty obj = service.findById(dto.getIdSpecialty());
		if (obj == null) {
			throw new ModelNotFoundException("ID NOT FOUND: " + dto.getIdSpecialty());
		}
		return new ResponseEntity<>(service.update(mapper.map(dto, Specialty.class)), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
		Specialty obj = service.findById(id);
		if (obj == null) {
			throw new ModelNotFoundException("ID NOT FOUND: " + id);
		}
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/hateoas/{id}")
	public EntityModel<SpecialtyDTO> findIdHateos(@PathVariable("id") Integer id){
		SpecialtyDTO dtoResponse;
		Specialty obj = service.findById(id);
		if (obj == null) {
			throw new ModelNotFoundException("ID NOT FOUND: " + id);
		}
		else {
			dtoResponse = mapper.map(obj, SpecialtyDTO.class);
		}
		EntityModel<SpecialtyDTO> resource = EntityModel.of(dtoResponse);
		WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).findById(id));
		WebMvcLinkBuilder link2 = linkTo(methodOn(this.getClass()).findAll());
		resource.add(link1.withRel("specialty-info1"));
		resource.add(link2.withRel("specialty-full"));
		return resource;		
	}
	
}
