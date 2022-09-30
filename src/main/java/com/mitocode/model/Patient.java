package com.mitocode.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table (name= "tblPaciente")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPatient;
	
	@Column(length = 70, nullable = false)
	private String firstName;
	
	@Column(length = 70, nullable = false)
	private String lastName;
	
	@Column(length = 8, nullable = false)
	private String dni;
	
	@Column(length = 200, nullable = false)
	private String address;
	
	@Column(length = 9, nullable = false)
	private String phone;
	
	@Column(length = 50, nullable = false)
	private String email;
	
}

