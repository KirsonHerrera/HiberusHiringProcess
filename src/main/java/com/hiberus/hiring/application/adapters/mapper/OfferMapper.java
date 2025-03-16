package com.hiberus.hiring.application.adapters.mapper;

import java.io.Serializable;

import org.modelmapper.ModelMapper;


import com.hiberus.hiring.domain.model.Offer;
import com.hiberus.hiring.domain.model.OfferByPartNumber;
import com.hiberus.hiring.domain.persistence.entity.OfferEntity;

/**
 * The mapper class
 */
public class OfferMapper implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -7995320598748294528L;
	private transient ModelMapper mapper;
	
	public OfferMapper() {}
	
	public OfferMapper(ModelMapper mapper) {
		if(mapper==null)
		{
			this.mapper = new ModelMapper();
		}else {
			this.mapper = mapper;
		}
	}
	
	public Offer toModel(OfferEntity entity) {
		return mapper.map(entity, Offer.class);
	}
	
	public OfferEntity toEntity(Offer model) {
		return mapper.map(model, OfferEntity.class);
	}
	
	/**
	 * return Offer from OfferEntity
	 * @param source
	 * @return
	 */
	public Offer toModelManual(OfferEntity source) {
		Offer destination = new Offer();
		
		destination.setOfferId(source.getOfferId());
		destination.setBrandId(source.getBrandId());
		destination.setCurrencyIso(source.getCurrencyIso());
		destination.setStartDate(source.getStartDate());
		destination.setEndDate(source.getEndDate());
		destination.setPrice(source.getPrice());
		destination.setPriceListId(source.getPriceListId());
		destination.setPriority(source.getPriority());
		destination.setProductPartnumber(source.getProductPartnumber());
		
		return destination;
	}
	
	/**
	 * Return OfferEntity from Offer
	 * @param source
	 * @return
	 */
	public OfferEntity toEntityManual(Offer source) {
		OfferEntity destination = new OfferEntity();
		
		destination.setOfferId(source.getOfferId());
		destination.setBrandId(source.getBrandId());
		destination.setCurrencyIso(source.getCurrencyIso());
		destination.setStartDate(source.getStartDate());
		destination.setEndDate(source.getEndDate());
		destination.setPrice(source.getPrice());
		destination.setPriceListId(source.getPriceListId());
		destination.setPriority(source.getPriority());
		destination.setProductPartnumber(source.getProductPartnumber());
		
		return destination;
	}
	
	/**
	 * Return OfferByPartNumber from Offer
	 * @param offer
	 * @return
	 */
	public OfferByPartNumber fromOfferToOfferByPartNumber(Offer offer) {
		return new OfferByPartNumber(offer.getStartDate(),offer.getEndDate(),offer.getPrice(),offer.getCurrencyIso());
	}
}
