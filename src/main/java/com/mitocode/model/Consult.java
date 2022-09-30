package com.mitocode.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "tblConsulta", schema= "")
public class Consult {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConsult;

	@ManyToOne
	@JoinColumn(name = "id_patient", nullable = false, foreignKey = @ForeignKey(name = "FK_CONSULT_PATIENT"))
	private Patient patient;// JPQL
	
	@ManyToOne
	@JoinColumn(name = "id_medic", nullable = false, foreignKey = @ForeignKey(name = "FK_CONSULT_MEDIC"))
	private Medic medic;// JPQL
	
	@ManyToOne
	@JoinColumn(name = "id_specialty", nullable = false, foreignKey = @ForeignKey(name = "FK_CONSULT_SPECIALTY"))
	private Specialty specialty;// JPQL
	
	@Column(length = 3, nullable = false)
	private String numConsult;
	
	@Column(nullable = false)
	private LocalDateTime consultDate;
	
	@OneToMany(mappedBy = "consult", cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.EAGER) 
	//FetchType-LAZY: sus hijos llegan null (esta por default), EAGER: trae una lista de sus hijos
	//orphanRemoval: te permite eliminar solo un hijo
	//ACID:Atomicidad-Consistencia-Aislamiento (Isolation)-Durabilidad
	private List<ConsultDetail> details;
	
	
}
