package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "direccion")
public class Direccion {
    @Id
    private int id;

    @Column(name = "calle")
    @NotNull
    private String calle;

    @Column(name = "numero")
    @NotNull
    private String numero;

    @Column(name = "municipio")
    @NotNull
    private String municipio;

    public Direccion() {
    }

    public Direccion(int id, String calle, String numero, String municipio) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.municipio = municipio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}