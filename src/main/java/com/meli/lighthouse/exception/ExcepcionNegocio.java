package com.meli.lighthouse.exception;

import org.springframework.http.HttpStatus;

public class ExcepcionNegocio extends RuntimeException{
	
	private final HttpStatus estado;
	
	public ExcepcionNegocio (String mensaje , HttpStatus codigoEstado) {
		super(mensaje);
		this.estado = codigoEstado;		
	}

	public HttpStatus getEstado() {
		return estado;
	}	

}
