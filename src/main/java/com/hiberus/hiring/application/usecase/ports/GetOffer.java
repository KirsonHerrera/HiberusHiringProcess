package com.hiberus.hiring.application.usecase.ports;

import java.util.List;

import com.hiberus.hiring.domain.model.Offer;
import com.hiberus.hiring.exception.OfferNotFoundException;

public interface GetOffer {
	
	public Offer getOffer(Long id) throws OfferNotFoundException;
	public List<Offer> getAllOffer();

}
