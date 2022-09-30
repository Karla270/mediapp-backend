package com.mitocode.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data//es la anotación de acceso directo que agrupa las características de @ToString, @EqualsAndHashCode, @Getter/@Setter y 
//@RequiredArgsConstructor juntas: en otras palabras.
@AllArgsConstructor //genera un constructor con un parámetro para cada campo en su clase.
@NoArgsConstructor // generará un constructor sin parámetros
public class SpecialtyDTO {

	@EqualsAndHashCode.Include
	private Integer idSpecialty;	
	
    @NotEmpty
    @Size(min = 3, message = "{firstname.size}")
    private String name;

    @NotNull
    @Size(min = 3, message = "{lastname.size}")
    private String description;

}
