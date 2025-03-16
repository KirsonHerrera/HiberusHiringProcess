package com.hiberus.hiring.infraestructure.adapters.base;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hiberus.hiring.domain.model.Offer;
import com.hiberus.hiring.domain.model.TransactionInfo;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Base message class to format and build 
 * input and output API request and response
 */
@Builder
@Data
@Getter 
@Setter
@JsonIgnoreProperties("inspection")
public class BaseMessage implements Serializable{

	/**
	 * Serial verion
	 */
	private static final long serialVersionUID = 6959500001759257221L;
	
	@JsonProperty("offer")
	public Offer offer;
	
	@JsonProperty
	public TransactionInfo transactionInfo;
	
	public Offer getOffer() {
		return offer;
	}
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	public TransactionInfo getTransactionInfo() {
		return transactionInfo;
	}
	public void setTransactionInfo(TransactionInfo transactionInfo) {
		this.transactionInfo = transactionInfo;
	}
	
	
}
