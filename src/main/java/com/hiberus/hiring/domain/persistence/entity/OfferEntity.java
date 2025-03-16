package com.hiberus.hiring.domain.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="OfferEntity")
public class OfferEntity implements Serializable {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 5312215363283973672L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long offerId;

	@Column(name="brand_id")
	private Integer brandId;

	@Column(name="start_date")
	private String startDate;

	@Column(name="end_date")
    private String endDate;

	@Column(name="price_list_id")
	private Long priceListId;

	@Column(name="product_partnumber")
	private String productPartnumber;

	@Column(name="priority")
    private Integer priority;

	@Column(name="price")
	private BigDecimal price;

	@Column(name="currency_iso")
    private String currencyIso;
	
	public OfferEntity() {}

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
    
    
}
