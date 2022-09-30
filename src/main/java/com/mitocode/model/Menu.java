package com.mitocode.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "tblMenu")
public class Menu {

	@Id
	private Integer idMenu;
	
	@Column(length = 20, nullable = false)
	private String icon;
	
	@Column(length = 20, nullable = false)
	private String name;
	
	@Column(length = 50, nullable = false)
	private String url;
	
	@ManyToMany(fetch = FetchType.EAGER)
	//FetchType-LAZY: sus hijos llegan null (esta por default), EAGER: trae una lista de sus hijos
	@JoinTable(name = "menu_role", joinColumns = @JoinColumn(name = "id_menu", referencedColumnName = "idMenu", foreignKey = @ForeignKey(name = "FK_MENU")),
			  inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "idRole", foreignKey = @ForeignKey(name = "FK_ROLE")))
	private List<Role> roles;
	
}
