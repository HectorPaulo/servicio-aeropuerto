package com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.models.PasajeroModel;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.service.PasajeroService;
import com.edu.mx.lasalle.oaxaca.servicio_aeropuerto.utils.customResponse;

@RestController
@RequestMapping("/api/v1/pasajero")
public class PasajeroController {
    @Autowired
    private PasajeroService pasajeroService;

    @PostMapping("/registro")
    public customResponse registrarPasajero(PasajeroModel pasajeroModel) {
        customResponse customResponse = new customResponse();
        pasajeroService.registrarPasajero(pasajeroModel);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMessage("Se ha registrado el pasajero");
        return customResponse;
    }

    @GetMapping("/registros")
    public ResponseEntity<List<PasajeroModel>> getAllPasajeros() {
        List<PasajeroModel> pasajeros = pasajeroService.obtenerPasajeros();
        if (pasajeros.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(pasajeros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPasajero(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new customResponse(HttpStatus.OK,
                            pasajeroService.getPasajeros(id),
                            "show all matches", 200));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new customResponse(HttpStatus.UNPROCESSABLE_ENTITY,
                            pasajeroService.getPasajeros(id),
                            "ERROR: " + e, 422));
        }
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> updatePasajero(
            @RequestBody PasajeroModel pasajeroModel,
            @PathVariable(value = "id") int id) {
        ResponseEntity<Object> response = null;
        customResponse customResponse = new customResponse();
        try {
            if (pasajeroService.getPasajeros(id) == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new customResponse(HttpStatus.NO_CONTENT,
                                "", "This action can't execute, not found with id " + id,
                                204));
            }
            pasajeroService.actualizarDatosPasajero(pasajeroModel, id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Updated Successfully");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage("Error: " + e);
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        }
    }

    @DeleteMapping("/{id}/borrar")
    public ResponseEntity<Object> deletePasajero(@PathVariable int id) {
        ResponseEntity<Object> responseEntity = null;
        customResponse customResponse = new customResponse();
        try {
            pasajeroService.borrarPasajero(id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("DELETE SUCCESS");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }
}