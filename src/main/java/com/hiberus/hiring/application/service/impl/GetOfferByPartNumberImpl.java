package com.hiberus.hiring.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hiberus.hiring.application.usecase.ports.GetOfferByPartNumber;
import com.hiberus.hiring.domain.model.Offer;
import com.hiberus.hiring.domain.persistence.entity.OfferEntity;

@Service
public class GetOfferByPartNumberImpl extends BaseApplicationService implements GetOfferByPartNumber{

	@Override
	public List<Offer> findByBrandIdAndPartNumber(Integer brandId, String partnumber) {
		List<Offer> result = new ArrayList<>();
		
		List<OfferEntity> tempList = offerPersistence.findByBrandIdAndPartnumber(brandId, partnumber);
		
		if(tempList!=null && !tempList.isEmpty()) {
			
			for(OfferEntity oe:tempList) {
				
				result.add(offerMapper.toModel(oe));
			}

		}
		
		return result;
	}

}
