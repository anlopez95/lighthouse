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

import com.meli.lighthouse.model.dtosComplejos.rq.ConsultaTopSecretRqDTO;
import com.meli.lighthouse.model.dtosComplejos.rs.ConsultaTopSecretRsDTO;
import com.meli.lighthouse.model.dtosComplejos.rs.GenericoDataRsDTO;
import com.meli.lighthouse.service.IPosicionamientoSerive;
import com.meli.lighthouse.utils.Constantes;

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
	@PostMapping("/")
	public ResponseEntity<GenericoDataRsDTO<ConsultaTopSecretRsDTO>> obtenerUbicacion(@RequestBody ConsultaTopSecretRqDTO data) {
		GenericoDataRsDTO<ConsultaTopSecretRsDTO> respuesta = posicionamientoService.GetPosicion(data);		
		if (respuesta == null ) {
            return new ResponseEntity<>(respuesta,HttpStatus.NOT_FOUND);
        } else if (Constantes.TIPO_MENSAJE_ERROR.equals(respuesta.getTipoError())){
        	return new ResponseEntity<>(respuesta,HttpStatus.NOT_FOUND);
        } else {
        	return new ResponseEntity<>(respuesta,HttpStatus.OK);
        }
		
	}

}
