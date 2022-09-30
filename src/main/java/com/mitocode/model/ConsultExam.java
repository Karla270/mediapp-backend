package com.mitocode.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import lombok.Data;

@Data
@Entity
//@Table(name = "tblConsultaExamen")
@IdClass (ConsultExamPK.class) //Es utilizada para definir llaves primarias compuetas
public class ConsultExam {
	
	@Id
	private Consult consult;
	
	@Id
	private Exam exam;
}
