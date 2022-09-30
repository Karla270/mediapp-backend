package com.mitocode.controller;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.mitocode.dto.SignDTO;
import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Sign;
import com.mitocode.service.ISignService;

@RestController
@RequestMapping("/signs")
public class SignController {
	 @Autowired
	    private ISignService service;

	    @Autowired
	    private ModelMapper mapper;

	    @GetMapping
	    public ResponseEntity<List<SignDTO>> findAll() {
	        List<SignDTO> list = service.findAll().stream().map(p -> mapper.map(p, SignDTO.class)).collect(Collectors.toList());
	        return new ResponseEntity<>(list, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<SignDTO> findById(@PathVariable("id") Integer id) {
	    	SignDTO dtoResponse;
	        Sign obj = service.findById(id);
	        if (obj == null) {
	            throw new ModelNotFoundException("ID NOT FOUND: " + id);
	        } else {
	            dtoResponse = mapper.map(obj, SignDTO.class);
	        }
	        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	    }

	    @PostMapping
	    public ResponseEntity<Void> save(@Valid @RequestBody SignDTO dto) {
	    	System.out.println("getSignDate: " + dto.getSignDate());
	    	Sign p = service.save(mapper.map(dto, Sign.class));
	        //localhost:8080/patients/3
	        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdSign()).toUri();
	        return ResponseEntity.created(location).build();
	    }

	    @PutMapping
	    public ResponseEntity<Sign> update(@Valid @RequestBody SignDTO dto) {
	    	Sign obj = service.findById(dto.getIdSign());
	        if (obj == null) {
	            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getIdSign());
	        }

	        return new ResponseEntity<>(service.update(mapper.map(dto, Sign.class)), HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
	    	Sign obj = service.findById(id);
	        if (obj == null) {
	            throw new ModelNotFoundException("ID NOT FOUND: " + id);
	        } else {
	            service.delete(id);
	        }
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }


	    @GetMapping("/pageable")
	    public ResponseEntity<Page<SignDTO>> listPage(Pageable pageable){
	        Page<SignDTO> page = service.listPage(pageable).map(p -> mapper.map(p, SignDTO.class));
	        return new ResponseEntity<>(page, HttpStatus.OK);
	    }
}
