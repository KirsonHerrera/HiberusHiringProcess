package com.hiberus.hiring.application.usecase.ports;

import java.util.List;

import com.hiberus.hiring.domain.model.Offer;

public interface GetOfferByPartNumber {


	public List<Offer> findByBrandIdAndPartNumber(Integer brandId, String partnumber);
}
