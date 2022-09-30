package com.mitocode.service;

import java.util.List;


public interface ICRUD <T, ID>{

	T save(T table);
	T update(T table);
	T findById(ID id);
	List<T> findAll();
	void delete(ID id);
}
