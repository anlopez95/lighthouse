package com.meli.lighthouse.model.dtosComplejos.response;

import com.meli.lighthouse.exception.ExcepcionNegocio;

import lombok.Data;

@Data
public class ErrorResponseDTO {
	
	/**
	 * Mensaje de error obtenido
	 */
	String mensaje;
	
	/**
	 * ID de estado error obtenido
	 */
	int codigoEstado;

	public ErrorResponseDTO(ExcepcionNegocio ex) {
		mensaje = ex.getMessage();
		codigoEstado = ex.getEstado().value();
	}
}
