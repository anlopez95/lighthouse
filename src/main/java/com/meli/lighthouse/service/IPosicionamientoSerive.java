package com.meli.lighthouse.service;

import com.meli.lighthouse.exception.ExcepcionNegocio;
import com.meli.lighthouse.model.dtosComplejos.request.ConsultaTopSecretRqDTO;
import com.meli.lighthouse.model.dtosComplejos.response.ConsultaTopSecretRsDTO;

public interface IPosicionamientoSerive {

	/**
	 * Método encargado de responder la información de posicion del emisor
	 * @param data : Datos de los satelites
	 * @return Posicion del objivo
	 */
	public ConsultaTopSecretRsDTO GetPosicion(ConsultaTopSecretRqDTO data) throws ExcepcionNegocio;	

}
