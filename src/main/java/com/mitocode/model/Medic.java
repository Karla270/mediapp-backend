package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // (name= "medico")
//@Table(name = "tblMedico")
public class Medic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMedic;
	
	@Column(length = 70, nullable = false)
	private String firstName;
	
	@Column(length = 70, nullable = false)
	private String lastName;
	
	@Column(length = 12, nullable = false, unique = true)
	private String cmp;
	
	private String photoUrl;

}
