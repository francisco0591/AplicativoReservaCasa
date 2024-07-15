package com.fjulca.reserva.enums;

public enum MensajeRespuesta {

	MSG_OK_REGISTRO("Su registro se realizo correctamente"),
	MSG_ERROR_REGISTRO("Ocurrio un error al grabar su registro"),
	MSG_ERROR_BORRAR("Ocurrio un error al borrar registro"),
	MSG_ERROR_CONSULTA("Ocurrio un error al consultar los datos"),
	MSG_ERROR_CONFLICTO("conflict"),
	MSG_ERROR_INVALIDO_DISCOUNT("Invalid discount nulo o status false");
	
	
	private String strPv_valor;

	private MensajeRespuesta(String strA_valor){
		this.strPv_valor = strA_valor;
	}
	
	public String getStrPv_valor() {
		return strPv_valor;
	}
	
}
