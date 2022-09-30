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
public class MedicDTO {

	@EqualsAndHashCode.Include
	private Integer idMedic;	
	
    @NotEmpty
//    @Size(min = 3, message = "{firstname.size}")
    private String firstName;

    @NotNull
//    @Size(min = 3, message = "{lastname.size}")
    private String lastName;

    @Size(min = 12)
    private String cmp;

    private String photoUrl;

    /*@Max(1)
    @Min(34)
    private Integer edad;

    @Pattern(regexp = "")
    private String test;*/
	
}
