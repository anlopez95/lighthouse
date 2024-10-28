package com.meli.lighthouse.controller;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meli.lighthouse.model.SatelitesDTO;
import com.meli.lighthouse.model.dtosComplejos.response.ConsultaTopSecretRsDTO;
import com.meli.lighthouse.service.IPosicionamientoSerive;
import com.meli.lighthouse.store.SateliteDataStore;
import com.meli.lighthouse.utils.Triangulacion;

@RestController
@CrossOrigin (origins = "*", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/topsecret_split")
public class ActualizarUbicacionController {
	
	@Autowired
	IPosicionamientoSerive posicionamientoService;
	
	@Autowired
	SateliteDataStore dataStorageSatelites;
	
	/**
	 * Servicio encargado de obtener posicion
	 * @param distancias
	 * @return
	 * @author AFLOPEZ
	 */
	@PostMapping("/{satellite_name}")
    public ResponseEntity<Void> updateSatellite(@PathVariable("satellite_name") String name, @RequestBody SatelitesDTO satellite) {
		dataStorageSatelites.updateSatelliteData(name, satellite);
        return ResponseEntity.ok().build();
		
	}
	
	/**
	 * Servicio para obtener la consulta de posicion y mensaje
	 * @return
	 */
	@GetMapping("/details")
    public ResponseEntity<ConsultaTopSecretRsDTO> getTopSecretSplit() {
        Collection<SatelitesDTO> satellites = dataStorageSatelites.getAllSatellites();

        if (satellites.size() < 3) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Calcula la posición y el mensaje
        List<SatelitesDTO> satelitesList = new ArrayList<>(satellites);
        Point position = posicionamientoService.posicion(satelitesList);
        String message = posicionamientoService.getMensaje(satelitesList);

        if (position == null || message == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        ConsultaTopSecretRsDTO response = new ConsultaTopSecretRsDTO(position.x, position.y, message);
        return ResponseEntity.ok(response);
    }
	
	

}
