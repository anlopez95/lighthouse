package com.meli.lighthouse.service;

import java.awt.Point;
import java.util.List;

import com.meli.lighthouse.exception.ExcepcionNegocio;
import com.meli.lighthouse.model.SatelitesDTO;
import com.meli.lighthouse.model.dtosComplejos.request.ConsultaTopSecretRqDTO;
import com.meli.lighthouse.model.dtosComplejos.response.ConsultaTopSecretRsDTO;

public interface IPosicionamientoSerive {

	/**
	 * Método encargado de responder la información de posicion del emisor
	 * @param data : Datos de los satelites
	 * @return Posicion del objivo
	 */
	public ConsultaTopSecretRsDTO GetPosicion(ConsultaTopSecretRqDTO data) throws ExcepcionNegocio;

	/**
	 * Método encargado de obtener la posición por triangulación
	 * @param satelites : Informacion en forma de lista de los satelites
	 * @return Devuelve la posicion encontrada usando los 3 satelites
	 */
	public Point posicion(List<SatelitesDTO> satelites);

	/**
	 * Método encargado de obtener el mensaje enviado
	 * @param satelites : Informacion en forma de lista de los satelites
	 * @return Devuelve el mensaje obtenido
	 */
	public String getMensaje(List<SatelitesDTO> satelites);	

}
