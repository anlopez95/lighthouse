package com.meli.lighthouse.model;

import org.springframework.validation.annotation.Validated;

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
	private double distance;

	/**
	 * Mensaje al satelite
	 */
	@NotEmpty(message = "El mensaje es obligatorio y no puede estar vacío")
	private String[] message;

	public boolean tieneCamposNulos() {
		return name == null || message == null;
	}

	public boolean tieneValoresPorDefecto() {
		return name.isEmpty() || (message.length == 0);
	}

}
