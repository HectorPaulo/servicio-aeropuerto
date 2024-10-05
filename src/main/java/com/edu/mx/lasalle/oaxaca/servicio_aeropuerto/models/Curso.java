package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @Column(name = "clave_curso")
    private String clave_curso;
    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, mappedBy = "clave_curso")
    private Set<Estudiante> estudiantes = new HashSet<>();
}
