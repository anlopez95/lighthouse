package com.meli.lighthouse.model;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String[] getMessage() {
		return message;
	}

	public void setMessage(String[] message) {
		this.message = message;
	}
	
	
	
	

}
