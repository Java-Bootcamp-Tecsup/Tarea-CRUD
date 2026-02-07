package com.codigo.api_bd.dto;

import java.util.UUID;

public record AlumnoResponse(UUID id,
                             String nombre,
                             int edad) {
}