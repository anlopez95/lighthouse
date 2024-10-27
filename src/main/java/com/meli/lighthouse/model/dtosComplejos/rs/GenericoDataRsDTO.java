package com.meli.lighthouse.model.dtosComplejos.rs;

public class GenericoDataRsDTO<T> extends GenericoRsDTO {
	
	private T data;

	public T getDatoGenerico() {
		return data;
	}

	public void setDatoGenerico(T datoGenrico) {
		this.data = datoGenrico;
	}
	
}
