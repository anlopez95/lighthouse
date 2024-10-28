package com.meli.lighthouse.model.dtosComplejos.request;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

import com.meli.lighthouse.exception.ExcepcionNegocio;
import com.meli.lighthouse.model.SatelitesDTO;
import com.meli.lighthouse.utils.Constantes;

import lombok.Data;

@Data
@Validated
public class ConsultaTopSecretRqDTO {

	/**
	 * Objeto que contiene la información de los satelites enviada en el request
	 */
	List<SatelitesDTO> satelites;

	// Método para obtener las distancias en un array de double
	public double[] getDistances() {
		return satelites.stream().mapToDouble(SatelitesDTO::getDistance).toArray();
	}

	// Método para obtener los mensajes en un array de arrays de String
	public String[][] getMessages() {
		return satelites.stream().map(SatelitesDTO::getMessage).toArray(String[][]::new);
	}

	/**
	 * Método encargado de validar la información de los satelites
	 * 
	 * @return
	 */
	public boolean tieneSatelitesNulos() {

		for (SatelitesDTO satelite : satelites) {
			if (satelite.tieneCamposNulos() || satelite.tieneValoresPorDefecto()) {
				return true;
			}
		}
		return false;
	}

	public boolean tieneConflictoMensajes() {

		for (SatelitesDTO satelite : satelites) {
			if (satelite.tieneCamposNulos() || satelite.tieneValoresPorDefecto()) {
				return true;
			}
		}
		return false;
	}

	public void tieneMensajesInconsistencias() {

		// Longitud esperada del mensaje, tomada del primer satélite
		int longitudMensajeEsperada = satelites.get(0).getMessage().length;

		// Verificar que todos los satélites tengan un mensaje con la misma longitud
		for (SatelitesDTO satelite : satelites) {
			if (satelite.getMessage().length != longitudMensajeEsperada) {
				throw new ExcepcionNegocio(Constantes.DISTINTA_LONGITUD_MENSAJES, HttpStatus.BAD_REQUEST);
			}
		}

		// Validar que en cada posición no haya palabras diferentes
		for (int i = 0; i < longitudMensajeEsperada; i++) {
			Set<String> palabras = new HashSet<>();

			for (SatelitesDTO satelite : satelites) {
				String palabra = satelite.getMessage()[i].trim();

				// Si no está vacía, la añadimos al set
				if (!palabra.isEmpty()) {
					palabras.add(palabra);
				}
			}

			// Si hay más de una palabra en el mismo índice, lanza una excepción
			if (palabras.size() > 1) {
				String myStr = Constantes.MENSAJE_PALABRAS_DUPLICIDAD;
				String result = String.format(myStr, i, palabras);
				throw new ExcepcionNegocio(result, HttpStatus.BAD_REQUEST);
			}

		}
	}

}
