package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.mitocode.model.*;
import com.mitocode.repository.*;
import com.mitocode.service.*;


@Service
//las clases abstractas se heredan, las interface se implementan
public class PatientServiceImpl extends CRUDImpl<Patient, Integer> implements IPatientService{

	@Autowired
	private IPatientRepository repo;

	@Override
	protected IGenericRepository<Patient, Integer> getRepo() {
		return repo;
	}
	
   @Override
    public Page<Patient> listPage(Pageable page) {
        return repo.findAll(page);
    }
}
