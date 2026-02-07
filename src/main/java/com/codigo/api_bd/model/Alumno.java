package com.codigo.api_bd.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false, length = 120)
    private String nombre;
    @Column(nullable = false)
    private int edad;

    public Alumno() {
    }

    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}