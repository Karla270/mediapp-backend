package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mitocode.model.*;
import com.mitocode.repository.*;
import com.mitocode.service.*;


@Service
//las clases abstractas se heredan, las interface se implementan
public class MedicServiceImpl extends CRUDImpl<Medic, Integer> implements IMedicService{

	@Autowired
	private IMedicRepository repo;

	@Override
	protected IGenericRepository<Medic, Integer> getRepo() {
		return repo;
	}
	
}
