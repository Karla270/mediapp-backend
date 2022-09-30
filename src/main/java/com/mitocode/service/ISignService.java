package com.mitocode.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mitocode.model.Sign;

public interface ISignService extends ICRUD<Sign, Integer>{
	Page<Sign> listPage(Pageable page);
}
