package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "tblConsultaDetalle")
public class ConsultDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetail;
	
	@ManyToOne
	@JoinColumn(name = "id_consult", nullable = false, foreignKey = @ForeignKey(name = "FK_CONSULT_DETAIL"))
	private Consult consult;
	
	@Column(length = 70, nullable = false)
	private String diagnosis;
	
	@Column(length = 300, nullable = false)
	private String treatment;
	
}
