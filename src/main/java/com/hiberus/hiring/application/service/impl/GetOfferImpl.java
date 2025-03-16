package com.hiberus.hiring.application.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hiberus.hiring.application.usecase.ports.GetOffer;
import com.hiberus.hiring.domain.model.Offer;
import com.hiberus.hiring.domain.persistence.entity.OfferEntity;
import com.hiberus.hiring.exception.OfferNotFoundException;

@Service
public class GetOfferImpl extends BaseApplicationService implements GetOffer{

	@Override
	public Offer getOffer(Long id) throws OfferNotFoundException{
	
		Optional<OfferEntity> o = offerPersistence.findById(id);
		if(o.isPresent() || !o.isEmpty())
			return this.offerMapper.toModelManual(o.get());
		else
			throw new OfferNotFoundException("Id no existe "+id);
	}

	@Override
	public List<Offer> getAllOffer() {
		
		List<OfferEntity> oeList = offerPersistence.findAll();
		List<Offer> result = new ArrayList<>();
		
		if(oeList!=null && !oeList.isEmpty())
		{
			for(OfferEntity oe:oeList) {
				result.add(offerMapper.toModelManual(oe));
			}
		}
		
		return result;
	}
	
	

}
