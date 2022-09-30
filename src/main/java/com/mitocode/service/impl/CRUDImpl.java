package com.mitocode.service.impl;

import java.util.List;
import com.mitocode.repository.IGenericRepository;
import com.mitocode.service.ICRUD;
//es una clase de la que nunca se van a crear instancias: simplemente va a servir como superclase a otras clases
public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {
	
	//un método abstracto es un método de una clase (o también de una “interface” en Java) 
	//que no tiene implementación o definición (es decir, sólo tiene declaración)
	protected abstract IGenericRepository<T, ID> getRepo();

	@Override
	public T save(T table) {
		return getRepo().save(table);
	}

	@Override
	public T update(T table) {
		return getRepo().save(table);
	}

	@Override
	public T findById(ID id) {
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public List<T> findAll() {
		return getRepo().findAll();
	}

	@Override
	public void delete(ID id) {
		getRepo().deleteById(id);
	}

}
