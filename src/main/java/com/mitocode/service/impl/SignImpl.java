package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mitocode.model.Sign;
import com.mitocode.repository.IGenericRepository;
import com.mitocode.repository.ISignRepository;
import com.mitocode.service.ISignService;

@Service
public class SignImpl extends CRUDImpl<Sign, Integer> implements ISignService{

	@Autowired
	private ISignRepository repo;

	@Override
	protected IGenericRepository<Sign, Integer> getRepo() {
		return repo;
	}
	
   @Override
    public Page<Sign> listPage(Pageable page) {
        return repo.findAll(page);
    }

}
