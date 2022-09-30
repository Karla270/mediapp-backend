package com.mitocode.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor //genera un constructor con un parámetro para cada campo en su clase.
@NoArgsConstructor // generará un constructor sin parámetros
public class ExceptionResponse {

    private LocalDateTime datetime;
    private String message;
    private String details;
}
