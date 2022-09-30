package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mitocode.model.*;
import com.mitocode.repository.*;
import com.mitocode.service.*;


@Service
//las clases abstractas se heredan, las interface se implementan
public class SpecialtyServiceImpl extends CRUDImpl<Specialty, Integer> implements ISpecialtyService{

	@Autowired
	private ISpecialtyRepository repo;

	@Override
	protected IGenericRepository<Specialty, Integer> getRepo() {
		return repo;
	}
	
}
