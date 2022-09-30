package com.mitocode.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mitocode.model.*;

//@Service si es interface no es obligatorio, solo en clases
//Entre interfaces heredan (extends)
public interface IPatientService extends ICRUD<Patient, Integer>{

	Page<Patient> listPage(Pageable page);
}
