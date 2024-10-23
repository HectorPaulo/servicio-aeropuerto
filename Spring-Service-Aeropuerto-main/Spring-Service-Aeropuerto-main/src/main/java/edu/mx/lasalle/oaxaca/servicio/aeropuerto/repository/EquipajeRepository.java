package edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.EquipajeModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author paulo
 */
public interface EquipajeRepository extends JpaRepository<EquipajeModel, Integer>{
    public EquipajeModel findById (int id);
}
