package edu.mx.lasalle.oaxaca.servicio.aeropuerto.implement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mx.lasalle.oaxaca.servicio.aeropuerto.model.TripulacionModel;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.repository.TripulacionRepository;
import edu.mx.lasalle.oaxaca.servicio.aeropuerto.service.TripulacionService;

/**
 *
 * @author paulo
 */
@Service
public class TripulacionServiceImplements implements TripulacionService{
    @Autowired
    private TripulacionRepository TripulacionRepository;
    
    @Override
    public void registrarTripulacion(TripulacionModel tripulacionModel) {
        TripulacionRepository.save(tripulacionModel);
    }

    @Override
    public List<TripulacionModel> obtenerTripulaciones() {
        return TripulacionRepository.findAll();
    }

    @Override
    public TripulacionModel getTripulacion(int id) {
        return TripulacionRepository.findById(id);
    }

    @Override
    public void actualizarDatosTripulacion(TripulacionModel tripulacionModel, int id) {
       tripulacionModel.setIdTripulacion(id); 
       TripulacionRepository.save(tripulacionModel);
    }

    @Override
    public void borrarTripulacion(int id) {
       TripulacionRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLosTripulaciones() {
        TripulacionRepository.deleteAll();
    }
}
