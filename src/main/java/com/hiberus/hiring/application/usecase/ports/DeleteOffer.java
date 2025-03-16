package com.hiberus.hiring.application.usecase.ports;

import com.hiberus.hiring.domain.model.TransactionInfo;
import com.hiberus.hiring.exception.OfferNotFoundException;

public interface DeleteOffer {
	
	public TransactionInfo deleteOffer(Long offerId) throws OfferNotFoundException;
	public TransactionInfo deleteAllOffer();

}
