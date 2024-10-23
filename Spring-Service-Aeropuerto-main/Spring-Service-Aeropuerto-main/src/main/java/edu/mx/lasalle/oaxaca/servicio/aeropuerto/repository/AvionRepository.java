package edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.AvionModel;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author paulo
 */
public interface AvionRepository extends JpaRepository<AvionModel, Integer>{
    public AvionModel findById (int id);
}
