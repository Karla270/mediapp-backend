package com.mitocode.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Table(name = "user_data")
//@Table(name = "tblUsuario")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUser;
	
	@Column(length = 50, nullable = false, unique = true)
	private String username;
	
	@Column(length = 60, nullable = false)
	private String password;
	
	@Column(nullable = false)
	private boolean enabled;

	@ManyToMany(fetch = FetchType.EAGER)
	//FetchType-LAZY: sus hijos llegan null (esta por default), EAGER: trae una lista de sus hijos
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "idUser", foreignKey = @ForeignKey(name = "FK_USER")),
			  inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "idRole", foreignKey = @ForeignKey(name = "FK_ROLE")))
	private List<Role> roles;
		
}
