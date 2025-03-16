package com.hiberus.hiring.infraestructure.adapters.input;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hiberus.hiring.infraestructure.adapters.base.BaseMessage;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Request class for hiring execise
 */
@Builder
@Data
@Getter 
@Setter
@AllArgsConstructor
@JsonIgnoreProperties("inspection")
@EqualsAndHashCode(callSuper=false)
public class OfferRequest extends BaseMessage implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -5411317218811002119L;
	
	@JsonProperty
	public Long id;

	public OfferRequest() {
	
	}
	public OfferRequest(Long offerId) {
		this.id = offerId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}
