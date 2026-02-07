package com.codigo.api_bd.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AlumnoCreateRequest(
        @NotBlank(message = "Nombre es olbigatorio")
        @Size(min = 2, max = 120, message = "Nombre debe tener entre 2 y 120 caracteres")
        String nombre,

        @Min(value = 1, message = "Edad minima es 1")
        @Max(value = 120, message = "Edad maxima 120")
        int edad
) {
}