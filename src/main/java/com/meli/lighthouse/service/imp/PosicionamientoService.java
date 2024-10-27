package com.meli.lighthouse.service.imp;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.meli.lighthouse.model.SatelitesDTO;
import com.meli.lighthouse.model.dtosComplejos.rq.ConsultaTopSecretRqDTO;
import com.meli.lighthouse.model.dtosComplejos.rs.ConsultaTopSecretRsDTO;
import com.meli.lighthouse.model.dtosComplejos.rs.GenericoDataRsDTO;
import com.meli.lighthouse.service.IPosicionamientoSerive;
import com.meli.lighthouse.utils.Constantes;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PosicionamientoService implements IPosicionamientoSerive {

	private Point sateliteKenobi = new Point(-500, -200);
	private Point sateliteSkywalker = new Point(100, -100);
	private Point sateliteSato = new Point(500, 100);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GenericoDataRsDTO<ConsultaTopSecretRsDTO> GetPosicion(ConsultaTopSecretRqDTO datos) {
		
		GenericoDataRsDTO<ConsultaTopSecretRsDTO> resultadoFinal = new GenericoDataRsDTO<>();
		if (datos.getSatelites().size()<3) {
			resultadoFinal.setRespuesta(Boolean.FALSE, "ERR", "Datos para satelites insuficientes");
			return resultadoFinal;
		}

		// Calculamos la posición
		Point location = posicion(datos.getSatelites());

		// Reconstruimos el mensaje
		String message = getMensaje(datos.getSatelites());

		// Si no podemos determinar la posición o el mensaje completo
		if (location == null || message.isEmpty()) {
			resultadoFinal.setRespuesta(Boolean.FALSE, "ERR", "No se pudo determinar la posición o el mensaje.");
			return resultadoFinal;

		}

		ConsultaTopSecretRsDTO response = new ConsultaTopSecretRsDTO(location.x, location.y, message);
		
		resultadoFinal.setDatoGenerico(response);
		resultadoFinal.setRespuesta(Boolean.TRUE, Constantes.CADENA_VACIA, Constantes.CADENA_VACIA);
		
		return resultadoFinal;

	}

	public Point posicion(List<SatelitesDTO> satelites) {
		//Posiciones originales de cada satelite
		Point2D.Double p1 = new Point2D.Double(-500, -200); //Satelite Kenobi
        Point2D.Double p2 = new Point2D.Double(100, -100); //Satelite Skywalker
        Point2D.Double p3 = new Point2D.Double(500, 100); //Satelite Sato

        //Distancias de cada satelite a la nave
        double r1 = satelites.get(0).getDistance();
        double r2 = satelites.get(1).getDistance();
        double r3 = satelites.get(2).getDistance();
        
		// Calculamos (x, y) resolviendo el sistema de ecuaciones de trilateracion (Calculo de posicion usando geometria de triangulos)
        double A = 2 * p2.x - 2 * p1.x;
        double B = 2 * p2.y - 2 * p1.y;
        double C = Math.pow(r1, 2) - Math.pow(r2, 2) - Math.pow(p1.x, 2) + Math.pow(p2.x, 2) - Math.pow(p1.y, 2) + Math.pow(p2.y, 2);
        double D = 2 * p3.x - 2 * p2.x;
        double E = 2 * p3.y - 2 * p2.y;
        double F = Math.pow(r2, 2) - Math.pow(r3, 2) - Math.pow(p2.x, 2) + Math.pow(p3.x, 2) - Math.pow(p2.y, 2) + Math.pow(p3.y, 2);

        double x = (C * E - F * B) / (E * A - B * D);
        double y = (C * D - A * F) / (B * D - A * E);

		return new Point((int) x, (int) y);
	}

	public String getMensaje(List<SatelitesDTO> satelites) {
	    int maxLength = satelites.stream()
	                              .map(satellite -> satellite.getMessage().length)
	                              .max(Integer::compare)
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

}
