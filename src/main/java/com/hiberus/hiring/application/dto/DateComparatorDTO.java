package com.hiberus.hiring.application.dto;

import java.io.Serializable;

import com.hiberus.hiring.domain.model.Offer;

/**
 * DTO objet to perform some date compare methods
 */
public class DateComparatorDTO implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -7425184690641836552L;
	
	private Boolean isValidDate;
	private Boolean isValidRange;
	private Boolean isDateOverlap;
	private String dateStartIso;
	private String dateEndIso;
	private Offer currenOffer;
	private Offer overloadOffer;
	private String message;
	
	public DateComparatorDTO() {
		isValidDate = false;
		isValidRange = false;
		isDateOverlap = false;
	}
	
	public Boolean getIsValidDate() {
		return isValidDate;
	}
	public void setIsValidDate(Boolean isValidDate) {
		this.isValidDate = isValidDate;
	}
	public Boolean getIsValidRange() {
		return isValidRange;
	}
	public void setIsValidRange(Boolean isValidRange) {
		this.isValidRange = isValidRange;
	}
	public String getDateStartIso() {
		return dateStartIso;
	}
	public void setDateStartIso(String dateStartIso) {
		this.dateStartIso = dateStartIso;
	}
	public String getDateEndIso() {
		return dateEndIso;
	}
	public void setDateEndIso(String dateEndIso) {
		this.dateEndIso = dateEndIso;
	}
	public Offer getCurrenOffer() {
		return currenOffer;
	}
	public void setCurrenOffer(Offer currenOffer) {
		this.currenOffer = currenOffer;
	}
	public Offer getOverloadOffer() {
		return overloadOffer;
	}
	public void setOverloadOffer(Offer overloadOffer) {
		this.overloadOffer = overloadOffer;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getIsDateOverlap() {
		return isDateOverlap;
	}

	public void setIsDateOverlap(Boolean isDateOverlap) {
		this.isDateOverlap = isDateOverlap;
	}

	
	
	
}
