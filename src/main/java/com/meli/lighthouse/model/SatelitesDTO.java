package com.meli.lighthouse.model;

import java.math.BigDecimal;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Validated
public class SatelitesDTO {

	/**
	 * Nombre del satelite
	 */
	@NotBlank(message = "El nombre del satélite es obligatorio")
	private String name;

	/**
	 * Distancia del satelite
	 */
	@NotNull(message = "La distancia es obligatoria")
	@Min(value = 1, message = "La distancia debe ser un valor positivo")
	private BigDecimal distancia;
	
	/**
	 * Distancia del satelite
	 */
	@NotNull(message = "La distancia es obligatoria")
	@Min(value = 0, message = "La distancia debe ser un valor positivo")
	private double distance;

	/**
	 * Mensaje al satelite
	 */
	@NotEmpty(message = "El mensaje es obligatorio y no puede estar vacío")
	private String[] message;

	/**
	 * Método encargado de validar Campos nulos
	 * @return devuelve un boolean con el resultado
	 */
	public boolean tieneCamposNulos() {
		return name == null || message == null;
	}

	/**
	 * Método encargado de validar valores por defecto
	 * @return devuelve un boolean con el resultado
	 */
	public boolean tieneValoresPorDefecto() {
		return name.isEmpty() || (message.length == 0);
	}
	
	/**
	 * Método encargado de convertir la distancia entrante a un valor valido 
	 * @param number : Distancia en BigDecimal
	 * @return asigna a la propiedad del DTO lo obtenido en la conversion
	 */
	public double convertBigToDoub(BigDecimal number) {
		return distance = number.doubleValue();
	}

}
