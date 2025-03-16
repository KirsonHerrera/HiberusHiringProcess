package com.hiberus.hiring.domain.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
@Getter 
@Setter
@JsonIgnoreProperties("inspection")
public class TransactionInfo implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 4442646837320676341L;
	
	@JsonProperty
	public String status;
	@JsonProperty
	public String errorMessage;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
