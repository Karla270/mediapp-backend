package com.mitocode.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class Sign {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSign;

	@ManyToOne
	@JoinColumn(name = "id_patient", nullable = false, foreignKey = @ForeignKey(name = "FK_SIGN_PATIENT"))
	private Patient patient;// JPQL
	
	@Column(nullable = false)
	private LocalDateTime signDate;
	
	@Column(nullable = false)
	private String temperature;
	
	@Column(nullable = false)
	private String pulse;
	
	@Column(nullable = false)
	private String rate;

}
