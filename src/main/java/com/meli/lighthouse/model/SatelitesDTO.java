package com.meli.lighthouse.model;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SatelitesDTO {
	
	/**
	 * Nombre del satelite
	 */
	private String name;
	
	/**
	 * Distancia del satelite
	 */
	private double distance;
	
	/**
	 * Mensaje al satelite
	 */
	private String[] message ;	

}
