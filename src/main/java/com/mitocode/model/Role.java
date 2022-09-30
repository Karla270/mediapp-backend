package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "tblRol")
public class Role {

	@Id
	private Integer idRole;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 150, nullable = false)
	private String description;
	
}
