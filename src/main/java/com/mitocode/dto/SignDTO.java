package com.mitocode.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
public class SignDTO {

	@EqualsAndHashCode.Include
	private Integer idSign;	
	
   @NotNull
   private PatientDTO patient;
	   
    @NotEmpty
    private String temperature;

    @NotEmpty
    private String pulse;

    @NotEmpty
    private String rate;

    @NotNull
    private LocalDateTime signDate;
}
