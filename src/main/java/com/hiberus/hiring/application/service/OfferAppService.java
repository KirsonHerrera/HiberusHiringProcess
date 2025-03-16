package com.hiberus.hiring.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.hiring.application.dto.DateComparatorDTO;
import com.hiberus.hiring.application.service.impl.CreateOfferImpl;
import com.hiberus.hiring.application.service.impl.DeleteOfferImpl;
import com.hiberus.hiring.application.service.impl.GetOfferImpl;
import com.hiberus.hiring.application.validator.OfferDateValidator;
import com.hiberus.hiring.application.service.impl.GetOfferByPartNumberImpl;
import com.hiberus.hiring.domain.enums.TransactionInfoEnum;
import com.hiberus.hiring.domain.model.Offer;
import com.hiberus.hiring.domain.model.TransactionInfo;
import com.hiberus.hiring.exception.OfferNotFoundException;
import com.hiberus.hiring.exception.OfferWithDateOverlapException;
import com.hiberus.hiring.util.TechnicalTestLogger;

/**
 * Offer service at application layer
 */
@Service
public class OfferAppService {
	
	@Autowired
	CreateOfferImpl createOfferImpl;
	
	@Autowired
	DeleteOfferImpl deleteOfferImpl;
	
	@Autowired
	GetOfferByPartNumberImpl offerByPartnumber;
	
	@Autowired
	GetOfferImpl getOfferImpl;
	
	/**
	 * Create the offer
	 * @param offer
	 * @return
	 * @throws OfferWithDateOverlapException
	 */
	public Offer createOffer(Offer offer) throws OfferWithDateOverlapException
	{
		if(offer==null) {
			TechnicalTestLogger.writeLogInfo("Offer is null");
		}else {
			TechnicalTestLogger.writeLogInfo("Data offer "+offer.toString());
		}
		
		DateComparatorDTO dc = this.validateOffer(offer);
		
		if(dc.getIsDateOverlap()) {
			throw new OfferWithDateOverlapException(TransactionInfoEnum.DATEOVERLAP_ERROR.getDescription());
		}
		
		return createOfferImpl.createOffer(offer);
	}
	
	/**
	 * Get the Offer
	 * @param id
	 * @return
	 */
	public Offer getOffer(Long id) throws OfferNotFoundException {
		return getOfferImpl.getOffer(id);
	}
	
	public List<Offer> getAllOffer() {
		return getOfferImpl.getAllOffer();
	}

	public TransactionInfo deleteOffer(Long id) throws OfferNotFoundException {
		
		return deleteOfferImpl.deleteOffer(id);
	}
	
	public TransactionInfo deleteAll()
	{
		return deleteOfferImpl.deleteAllOffer();
	}
	
	public List<Offer> getTimeTable(Offer offer) {
		return offerByPartnumber.findByBrandIdAndPartNumber(offer.getBrandId(), offer.getProductPartnumber());
	}
	
	
	/**
	 * Compare valid range 
	 * @param offer
	 * @return
	 */
	public DateComparatorDTO validateOffer(Offer offer)
	{
		DateComparatorDTO dc = new DateComparatorDTO();
		//be sure if the offer can´t overlap with others
		List<Offer> oList = offerByPartnumber.findByBrandIdAndPartNumber(offer.getBrandId(), offer.getProductPartnumber());
		if(oList!=null && !oList.isEmpty()) {
			//Compare overlap
			OfferDateValidator odv = new OfferDateValidator();
			for(Offer o:oList) {
				dc = odv.dateRangeRangeOverlap(offer, o);
				if(dc.getIsDateOverlap()) {
				   return dc;	
				}
			}
		}
		return dc;
	}
	
}
