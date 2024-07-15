package com.fjulca.reserva.enums;

public enum EstadoRespuesta {

	OK("200"),
	NO_CONTENT("204"),
	NOT_FOUND("404"),
	INTERNAL_SERVER_ERROR("500"),
	ERROR_REQUEST("00"),
	BAD_REQUEST("400");
	
	private String value;

	private EstadoRespuesta(String value) {
		setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
