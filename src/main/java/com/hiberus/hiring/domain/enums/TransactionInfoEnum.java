package com.hiberus.hiring.domain.enums;

public enum TransactionInfoEnum {

	SUCESS_RESPONSE("SUCESS","Transaccion existosa"),
	INVALIDADATE_RESPONSE("INVALIDDATE","Fechas no tienen un formato valido, use ISO8601"),
	INVALIDADATERANGE_RESPONSE("INVALIDDATERANGE","Rango de fechas no valido"),
	DATEOVERLAP_ERROR("DATEOVERLAP","Rango de fecha solapado con otra oferta en la base de datos"),
	NOTFOUND_RESPONSE("NOTFOUND","No se encontraron registros"),
	NOSAVE_RESPONSE("NOSAVE","Error al guardar registro"),
	NODELETE_RESPONSE("NODELETE","Error al eliminar registro"),
	NOUPDATE_RESPONSE("NOUPDATE","Error al actualizar registro"),
	ERROR_RESPONSE("ERROR","Error al procesar transaccion"),
	MISSINGOBJECT_RESPONSE("MISSINGERROR","Elemento no enviado"),
	EXCEPTION_RESPONSE("EXCEPTION","Se produjo una exception");
	
	
	String code;
	String description;
	
	TransactionInfoEnum(String code,String description){
		this.code=code;
		this.description=description;
	}

	public String getCode() {
		return code;
	}

	

	public String getDescription() {
		return description;
	}

	
}
