package com.meli.lighthouse.service;

import com.meli.lighthouse.model.dtosComplejos.rq.ConsultaTopSecretRqDTO;
import com.meli.lighthouse.model.dtosComplejos.rs.ConsultaTopSecretRsDTO;
import com.meli.lighthouse.model.dtosComplejos.rs.GenericoDataRsDTO;

public interface IPosicionamientoSerive {

	/**
	 * Método encargado de responder la información de posicion del emisor
	 * @param data : Datos de los satelites
	 * @return Posicion del objivo
	 */
	public GenericoDataRsDTO<ConsultaTopSecretRsDTO> GetPosicion(ConsultaTopSecretRqDTO data);	

}
