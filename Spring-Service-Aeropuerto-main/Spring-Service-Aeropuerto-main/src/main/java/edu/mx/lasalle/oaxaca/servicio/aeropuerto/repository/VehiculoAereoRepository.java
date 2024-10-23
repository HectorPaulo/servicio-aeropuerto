package edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.VehiculoAereoModel;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author paulo
 */
public interface VehiculoAereoRepository extends JpaRepository<VehiculoAereoModel, Integer>{
    public VehiculoAereoModel findById (int id);
}
