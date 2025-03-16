package com.hiberus.hiring.domain.model;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Simple pojo to transmit in all layers
 */

@Builder
@Data
@Getter 
@Setter
@JsonIgnoreProperties("inspection")
public class Offer implements Serializable {

	
	 /**
	 * Default serial version
	 */
	private static final long serialVersionUID = -2490367581887734281L;

	@JsonProperty
	private Long offerId;

	@JsonProperty("brandId")
	private Integer brandId;

	@JsonProperty("startDate")
	private String startDate;

	@JsonProperty
    private String endDate;

	@JsonProperty
	private Long priceListId;

	@JsonProperty
	private String productPartnumber;

	@JsonProperty
    private Integer priority;

	@JsonProperty
	private BigDecimal price;

	@JsonProperty
    private String currencyIso;
    
    public Offer() {}
	  
      /**
       * Offer constructor
       * @param offerId
       * @param brandId
       * @param startDate
       * @param endDate
       * @param priceListId
       * @param productPartnumber
       * @param priority
       * @param price
       * @param currencyIso
       */
	  public Offer(Long offerId, Integer brandId, String startDate, 
			       String endDate, Long priceListId, String productPartnumber,
		           Integer priority, BigDecimal price, String currencyIso) {

		    this.offerId = offerId;
		    this.brandId = brandId;
		    this.startDate = startDate;
		    this.endDate = endDate;
		    this.priceListId = priceListId;
		    this.productPartnumber = productPartnumber;
		    this.priority = priority;
		    this.price = price;
		    this.currencyIso = currencyIso;
		  }

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
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

	public Long getPriceListId() {
		return priceListId;
	}

	public void setPriceListId(Long priceListId) {
		this.priceListId = priceListId;
	}

	public String getProductPartnumber() {
		return productPartnumber;
	}

	public void setProductPartnumber(String productPartnumber) {
		this.productPartnumber = productPartnumber;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
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
	
	@Override
	public String toString() {
		String str="";
		
		 BeanInfo info;
	      try {
	          info = Introspector.getBeanInfo(this.getClass(), Object.class);
	          
	          PropertyDescriptor[] props = info.getPropertyDescriptors();
	          for (PropertyDescriptor pd : props) {
	              String nameProp = pd.getName();
	           
	              Method getterProp = pd.getReadMethod();
	              
	              if (getterProp != null) {
	                 Object value;
	                 try {
	                     value = getterProp.invoke(this);
	                     str=str+ " " + nameProp + " : " + value; 
	                 } catch (IllegalAccessException | IllegalArgumentException
	                          | InvocationTargetException ex) {
	                     return ex.getClass().getSimpleName() + ": " + ex.getMessage();
	                 }
	              }
	          }
	      } catch (IntrospectionException e) {
	          return e.getClass().getSimpleName() + ": " + e.getMessage();
	      }
		
		return str;
	}
	  

}
