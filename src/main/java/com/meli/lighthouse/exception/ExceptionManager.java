package com.meli.lighthouse.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.meli.lighthouse.model.dtosComplejos.response.ErrorResponseDTO;

@ControllerAdvice
public class ExceptionManager {

	@ExceptionHandler(ExcepcionNegocio.class)
	public ResponseEntity<ErrorResponseDTO> manejadorExcepcionNegocio(ExcepcionNegocio ex) {
		return ResponseEntity.status(ex.getEstado()).body(new ErrorResponseDTO(ex));
	}


}
