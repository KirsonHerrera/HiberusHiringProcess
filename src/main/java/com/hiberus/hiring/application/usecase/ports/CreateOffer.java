package com.hiberus.hiring.application.usecase.ports;

import com.hiberus.hiring.domain.model.Offer;

public interface CreateOffer {

	public Offer createOffer(Offer offer);
}
