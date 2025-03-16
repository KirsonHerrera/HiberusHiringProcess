package com.hiberus.hiring.application.service.impl;

import org.springframework.stereotype.Service;

import com.hiberus.hiring.application.usecase.ports.CreateOffer;
import com.hiberus.hiring.domain.model.Offer;
import com.hiberus.hiring.domain.persistence.entity.OfferEntity;
import com.hiberus.hiring.util.TechnicalTestLogger;

@Service
public class CreateOfferImpl extends BaseApplicationService implements CreateOffer {
	
	

	@Override
	public Offer createOffer(Offer offer) {
		
		TechnicalTestLogger.writeLogInfo("curr " +offer.getCurrencyIso());
		
		OfferEntity entity = offerPersistence.save(offerMapper.toEntity(offer));
		
		if(entity!=null) {
			TechnicalTestLogger.writeLogInfo("Entity es " + entity.getOfferId());
			
		}
		else {
			TechnicalTestLogger.writeLogInfo("Vino null");
		}
		
		return offerMapper.toModel(entity);
	}

}
