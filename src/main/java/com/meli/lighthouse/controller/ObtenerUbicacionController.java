package com.meli.lighthouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meli.lighthouse.exception.ExcepcionNegocio;
import com.meli.lighthouse.model.dtosComplejos.request.ConsultaTopSecretRqDTO;
import com.meli.lighthouse.model.dtosComplejos.response.ConsultaTopSecretRsDTO;
import com.meli.lighthouse.service.IPosicionamientoSerive;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin (origins = "*", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/topsecret")
public class ObtenerUbicacionController {
	
	@Autowired
	IPosicionamientoSerive posicionamientoService;
	
	/**
	 * Servicio encargado de obtener posicion
	 * @param distancias
	 * @return
	 * @author AFLOPEZ
	 */
	@Operation(summary ="Obtener ubicacion de la nave de recursos")
	@PostMapping("/")
	public ResponseEntity<ConsultaTopSecretRsDTO> obtenerUbicacion(@RequestBody ConsultaTopSecretRqDTO data) throws ExcepcionNegocio {
		ConsultaTopSecretRsDTO respuesta = posicionamientoService.GetPosicion(data);
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}

}
