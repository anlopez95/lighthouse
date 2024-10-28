package com.meli.lighthouse.model.dtosComplejos.rq;

import java.util.List;

import com.meli.lighthouse.model.SatelitesDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
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
    
    

}
