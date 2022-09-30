package com.mitocode.dto;

import javax.validation.constraints.Email;
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
public class PatientDTO {

	@EqualsAndHashCode.Include
	private Integer idPatient;	
	
    @NotEmpty
    @Size(min = 3, message = "{firstname.size}")
    private String firstName;

    @NotNull
    @Size(min = 3, message = "{lastname.size}")
    private String lastName;

    @Size(min = 8)
    private String dni;

    @Size(min = 3, max = 150)
    private String address;

    @Size(min = 9, max = 9)
    private String phone;

    @Email
    private String email;

    /*@Max(1)
    @Min(34)
    private Integer edad;

    @Pattern(regexp = "")
    private String test;*/
	
}
