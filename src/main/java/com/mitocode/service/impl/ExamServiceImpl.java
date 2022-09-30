package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mitocode.model.*;
import com.mitocode.repository.*;
import com.mitocode.service.*;


@Service
//las clases abstractas se heredan, las interface se implementan
public class ExamServiceImpl extends CRUDImpl<Exam, Integer> implements IExamService{

	@Autowired
	private IExamRepository repo;

	@Override
	protected IGenericRepository<Exam, Integer> getRepo() {
		return repo;
	}
	
}
