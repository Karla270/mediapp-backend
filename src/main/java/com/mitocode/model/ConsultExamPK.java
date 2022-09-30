package com.mitocode.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode //Genera los métodos equals() y hashCode() a partir de los campos del objeto
@Embeddable //Con esta anotación, indicamos que la clase puede ser «integrable» dentro de una entidad. 
public class ConsultExamPK implements Serializable{

	@EqualsAndHashCode.Include
	@ManyToOne
	@JoinColumn(name = "id_consult", foreignKey = @ForeignKey(name = "FK_CONSULT"))
	private Consult consult;
	
	@EqualsAndHashCode.Include
	@ManyToOne
	@JoinColumn(name = "id_exam", foreignKey = @ForeignKey(name = "FK_EXAM"))
	private Exam exam;
	
}
