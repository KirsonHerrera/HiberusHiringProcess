package com.hiberus.hiring.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * Use this POJO on the reponse for brand & partnumber & offer endPoint.
 */
public class OfferByPartNumber implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -4947130189499291888L;

	private String startDate;

	  private String endDate;

	  private BigDecimal price;

	  private String currencyIso;

	  public OfferByPartNumber() {

	  }

	  public OfferByPartNumber(String startDate, String endDate, BigDecimal price, String currencyIso) {

	    this.startDate = startDate;
	    this.endDate = endDate;
	    this.price = price;
	    this.currencyIso = currencyIso;
	  }

	  public String getStartDate() {
	    return startDate;
	  }

	  public void setStartDate(String startDate) {
	    this.startDate = startDate;
	  }

	  public String getEndDate() {
	    return endDate;
	  }

	  public void setEndDate(String endDate) {
	    this.endDate = endDate;
	  }

	  public BigDecimal getPrice() {
	    return price;
	  }

	  public void setPrice(BigDecimal price) {
	    this.price = price;
	  }

	  public String getCurrencyIso() {
	    return currencyIso;
	  }

	  public void setCurrencyIso(String currencyIso) {
	    this.currencyIso = currencyIso;
	  }
	  
	  
	  public String toString() {
		  String str="";
		  
		  str= "From " + this.startDate + " - until - " + this.endDate + " price: " + this.price.toString();
				  
		  return str ;
	  }
}
