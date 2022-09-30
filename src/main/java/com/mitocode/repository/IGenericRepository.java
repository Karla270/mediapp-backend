package com.mitocode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean //Anotación para excluir las interfaces del repositorio para que no se recojan
public interface IGenericRepository<T, ID> extends JpaRepository<T, ID>{

}
