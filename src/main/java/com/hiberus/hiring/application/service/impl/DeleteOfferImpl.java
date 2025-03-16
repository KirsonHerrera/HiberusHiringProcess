package com.hiberus.hiring.application.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hiberus.hiring.application.usecase.ports.DeleteOffer;
import com.hiberus.hiring.domain.enums.TransactionInfoEnum;
import com.hiberus.hiring.domain.model.TransactionInfo;
import com.hiberus.hiring.domain.persistence.entity.OfferEntity;
import com.hiberus.hiring.exception.OfferNotFoundException;

@Service
public class DeleteOfferImpl extends BaseApplicationService implements DeleteOffer{

	@Override
	public TransactionInfo deleteOffer(Long offerId) throws OfferNotFoundException  {
		
		Optional<OfferEntity> oe = offerPersistence.findById(offerId);
		if(oe.isPresent())
			return this.offerPersistence.delete(oe.get());
		else throw new OfferNotFoundException(TransactionInfoEnum.NODELETE_RESPONSE.getDescription());
	}

	@Override
	public TransactionInfo deleteAllOffer() {
	
		return offerPersistence.deleteAll();
	}

}
