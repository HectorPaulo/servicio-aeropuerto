package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.PasajeroModel;

public interface PasajeroRepository extends JpaRepository<PasajeroModel, Integer> {
    public PasajeroModel findById(int id);
}
