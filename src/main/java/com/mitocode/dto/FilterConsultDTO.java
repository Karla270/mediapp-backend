package com.mitocode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//es la anotación de acceso directo que agrupa las características de @ToString, @EqualsAndHashCode, @Getter/@Setter y 
//@RequiredArgsConstructor juntas: en otras palabras.
@AllArgsConstructor //genera un constructor con un parámetro para cada campo en su clase.
@NoArgsConstructor // generará un constructor sin parámetros
public class FilterConsultDTO {

	 private String dni;
	 private String fullname;
}
