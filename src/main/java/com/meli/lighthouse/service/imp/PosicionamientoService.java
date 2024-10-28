package com.meli.lighthouse.service.imp;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.meli.lighthouse.exception.ExcepcionNegocio;
import com.meli.lighthouse.model.SatelitesDTO;
import com.meli.lighthouse.model.dtosComplejos.request.ConsultaTopSecretRqDTO;
import com.meli.lighthouse.model.dtosComplejos.response.ConsultaTopSecretRsDTO;
import com.meli.lighthouse.service.IPosicionamientoSerive;
import com.meli.lighthouse.service.TriangulacionStrategy;
import com.meli.lighthouse.utils.Constantes;
import com.meli.lighthouse.utils.Triangulacion;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PosicionamientoService implements IPosicionamientoSerive {
	
	private final TriangulacionStrategy triangulacionStrategy;
	
	public PosicionamientoService(TriangulacionStrategy triangulacionStrategy) {
        this.triangulacionStrategy = triangulacionStrategy;
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConsultaTopSecretRsDTO GetPosicion(ConsultaTopSecretRqDTO datos) throws ExcepcionNegocio {

		ConsultaTopSecretRsDTO response = new ConsultaTopSecretRsDTO();
		// Convertir datos distancia
		datos.convertirDataBigToDouble();

		List<SatelitesDTO> listaSatelites = datos.getSatelites();
		// Validaciones iniciales de parametros
		if (datos.getSatelites().size() < Constantes.NUMERO_MINIMO_SATELITES) {
			throw new ExcepcionNegocio(Constantes.DATOS_INSUFICIENTES, HttpStatus.NOT_FOUND);
		}

		if (datos.tieneSatelitesNulos()) {
			throw new ExcepcionNegocio(Constantes.DATOS_NULOS, HttpStatus.BAD_REQUEST);
		}

		if (!validarParametrosSatelites(datos.getSatelites())) {
			throw new ExcepcionNegocio(Constantes.INFORMACION_SATELITES_INCOMPLETA, HttpStatus.BAD_REQUEST);
		}

		// Validar mensajes longitud y data
		datos.tieneMensajesInconsistencias();

		// Calculamos la posición
		Point location = GetLocation(datos.getSatelites());

		// Reconstruimos el mensaje
		String message = getMessage(datos.getSatelites());

		// Si no podemos determinar la posición o el mensaje completo
		if (location == null || message.isEmpty()) {
			throw new ExcepcionNegocio(Constantes.ERROR_DETERMINAR_POSICION_MENSAJE, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response = new ConsultaTopSecretRsDTO(location.x, location.y, message);

		return response;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Point GetLocation(List<SatelitesDTO> satelites) {
		// Posiciones originales de cada satelite
		Point2D.Double p1 = new Point2D.Double(-500, -200); // Satelite Kenobi
		Point2D.Double p2 = new Point2D.Double(100, -100); // Satelite Skywalker
		Point2D.Double p3 = new Point2D.Double(500, 100); // Satelite Sato

		// Distancias de cada satelite a la nave
		double r1 = satelites.get(0).getDistance();
		double r2 = satelites.get(1).getDistance();
		double r3 = satelites.get(2).getDistance();

		return triangulacionStrategy.triangulate(p1, p2, p3, r1, r2, r3);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMessage(List<SatelitesDTO> satelites) {
		int maxLength = satelites.stream().map(satellite -> satellite.getMessage().length).max(Integer::compare)
				.orElse(0);

		String[] message = new String[maxLength];

		for (int i = 0; i < maxLength; i++) {
			for (SatelitesDTO satellite : satelites) {
				if (i < satellite.getMessage().length && !satellite.getMessage()[i].isEmpty()) {
					message[i] = satellite.getMessage()[i];
					break;
				}
			}
		}

		return String.join(" ", message).trim();
	}

	/**
	 * Método encargado de validar los parametros enviados para cada uno de los
	 * satelites
	 * 
	 * @param listaSatelites : Informacion en forma de lista de los satelites
	 * @return Devuelve el resultado de la validación
	 */
	private boolean validarParametrosSatelites(List<SatelitesDTO> listaSatelites) {
		for (SatelitesDTO satelite : listaSatelites) {
			for (String message : satelite.getMessage()) {
				if (message == null) {
					return false;
				}
			}
		}
		return true;
	}

}
