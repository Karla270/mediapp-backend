package com.mitocode.service.impl;

import com.mitocode.model.ConsultExam;
import com.mitocode.repository.IConsultExamRepository;
import com.mitocode.service.IConsultExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultExamServiceImpl implements IConsultExamService {

    @Autowired
    private IConsultExamRepository repo;

    @Override
    public List<ConsultExam> getExamsByConsultId(Integer idConsult) {
        return repo.getExamsByConsultId(idConsult);
    }
}
