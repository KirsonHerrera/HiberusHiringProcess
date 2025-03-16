package com.hiberus.hiring.infraestructure.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.hiring.application.adapters.mapper.OfferMapper;
import com.hiberus.hiring.application.service.OfferAppService;
import com.hiberus.hiring.application.validator.OfferDateValidator;
import com.hiberus.hiring.domain.enums.TransactionInfoEnum;
import com.hiberus.hiring.domain.model.Offer;
import com.hiberus.hiring.domain.model.TransactionInfo;
import com.hiberus.hiring.exception.OfferWithDateOverlapException;
import com.hiberus.hiring.infraestructure.adapters.input.OfferRequest;
import com.hiberus.hiring.infraestructure.adapters.output.OfferResponse;

@Service
public class OfferInfraService {
   
	@Autowired
	OfferAppService offerApplicationService;
	
	/**
	 * Return a well format Offer object
	 * @param request
	 * @return
	 */
	public OfferResponse getOffer(OfferRequest request) {
		
		OfferResponse response = new OfferResponse();
		
		try {
		
			Offer o = offerApplicationService.getOffer(request.getId());
			
			if(o!=null) {
				response.setOffer(o);
				response.getTransactionInfo().setErrorMessage(TransactionInfoEnum.SUCESS_RESPONSE.getDescription());
			}
			else {
				response.getTransactionInfo().setStatus(TransactionInfoEnum.NOTFOUND_RESPONSE.getCode());
				response.getTransactionInfo().setErrorMessage(TransactionInfoEnum.NOTFOUND_RESPONSE.getDescription());
			}
		}catch(Exception e) {
			response.getTransactionInfo().setStatus(TransactionInfoEnum.NOTFOUND_RESPONSE.getCode());
			response.getTransactionInfo().setErrorMessage(TransactionInfoEnum.NOTFOUND_RESPONSE.getDescription()+ " " + e.getMessage());
		}
		
		return response;
	}
	

	/**
	 * Return all offers in the bdd 
	 * @return
	 */
	public OfferResponse getAllOffer() {
		
		OfferResponse response = new OfferResponse();
		
		try {
		
			List<Offer> oList = offerApplicationService.getAllOffer();
			
			if(oList!=null && !oList.isEmpty()) {
				response.setOfferList(oList);
				response.getTransactionInfo().setErrorMessage(TransactionInfoEnum.SUCESS_RESPONSE.getDescription());
			}
			else {
				response.getTransactionInfo().setStatus(TransactionInfoEnum.NOTFOUND_RESPONSE.getCode());
				response.getTransactionInfo().setErrorMessage(TransactionInfoEnum.NOTFOUND_RESPONSE.getDescription());
			}
		}catch(Exception e) {
			response.getTransactionInfo().setStatus(TransactionInfoEnum.NOTFOUND_RESPONSE.getCode());
			response.getTransactionInfo().setErrorMessage(TransactionInfoEnum.NOTFOUND_RESPONSE.getDescription()+ " " + e.getMessage());
		}
		
		return response;
	}
	
	/**
	 * Create a ofert
	 * @param request
	 * @return
	 */
	public OfferResponse createOffer(OfferRequest request) {
		
		OfferResponse response = new OfferResponse();
		if(request.getOffer()!=null) {
			
			
				try {
					OfferDateValidator odv = new OfferDateValidator();
					Boolean valDates = odv.dateRangeOk(request.getOffer());
					
					if(Boolean.FALSE.equals(valDates)) {
						
						response.getTransactionInfo().setStatus(TransactionInfoEnum.INVALIDADATERANGE_RESPONSE.getCode());
						response.getTransactionInfo().setErrorMessage(TransactionInfoEnum.INVALIDADATERANGE_RESPONSE.getDescription());
						return response;
					}else {
						Offer o = this.offerApplicationService.createOffer(request.getOffer());
						response.setOffer(o);
						response.getTransactionInfo().setErrorMessage(TransactionInfoEnum.SUCESS_RESPONSE.getDescription());
					
					}
					
					
				}catch(OfferWithDateOverlapException owdo) {
					
					response.getTransactionInfo().setStatus(TransactionInfoEnum.DATEOVERLAP_ERROR.getCode());
					response.getTransactionInfo().setErrorMessage(owdo.getMessage());
					return response;
				}
				catch(Exception dt) {
					
					response.getTransactionInfo().setStatus(TransactionInfoEnum.INVALIDADATE_RESPONSE.getCode());
					response.getTransactionInfo().setErrorMessage(TransactionInfoEnum.INVALIDADATE_RESPONSE.getDescription()+ " " + dt.getMessage());
					return response;
				}
			
			
		}
		else {
		
			response.getTransactionInfo().setStatus(TransactionInfoEnum.MISSINGOBJECT_RESPONSE.getCode());
			response.getTransactionInfo().setErrorMessage(TransactionInfoEnum.MISSINGOBJECT_RESPONSE.getDescription());
		}
		return response;
		
	}
	
	/**
	 * Delete a particular offerId
	 * @param request
	 * @return
	 */
	public OfferResponse deleteOffer(OfferRequest request) {
		
		OfferResponse response = new OfferResponse();
		if(request.getId()!=null) {
			
			try {
				TransactionInfo ti = this.offerApplicationService.deleteOffer(request.getId());
				response.setTransactionInfo(ti);
				response.getTransactionInfo().setErrorMessage(TransactionInfoEnum.SUCESS_RESPONSE.getDescription());
			
			}catch(Exception e) {
				response.getTransactionInfo().setStatus(TransactionInfoEnum.NODELETE_RESPONSE.getCode());
				response.getTransactionInfo().setErrorMessage(TransactionInfoEnum.NODELETE_RESPONSE.getDescription()+ " " + e.getMessage());
			}
			
		}
		else {
		
			response.getTransactionInfo().setStatus(TransactionInfoEnum.MISSINGOBJECT_RESPONSE.getCode());
			response.getTransactionInfo().setErrorMessage(TransactionInfoEnum.MISSINGOBJECT_RESPONSE.getDescription());
		}
		return response;
		
	}
	
	/**
	 * Delete all offers
	 * @return
	 */
	public OfferResponse deleteAllOffer() {
		
		OfferResponse response = new OfferResponse();
	
			
			try {
				TransactionInfo ti = this.offerApplicationService.deleteAll();
				response.setTransactionInfo(ti);
				response.getTransactionInfo().setErrorMessage(TransactionInfoEnum.SUCESS_RESPONSE.getDescription());
			
			}catch(Exception e) {
				response.getTransactionInfo().setStatus(TransactionInfoEnum.NODELETE_RESPONSE.getCode());
				response.getTransactionInfo().setErrorMessage(TransactionInfoEnum.NODELETE_RESPONSE.getDescription()+ " " + e.getMessage());
			}
			
		
		
		return response;
		
	}
	
	/**
	 * Return all offers in the bdd 
	 * @return
	 */
	public OfferResponse getTimeTable(OfferRequest request) {
		
		OfferResponse response = new OfferResponse();
		
		try {
		
			List<Offer> oList = offerApplicationService.getTimeTable(request.getOffer());
			List<String> strList = new ArrayList<>();
			if(oList!=null && !oList.isEmpty()) {
				response.setOfferList(oList);
				response.getTransactionInfo().setErrorMessage(TransactionInfoEnum.SUCESS_RESPONSE.getDescription());
				OfferMapper om = new OfferMapper();
				for(Offer o:oList) {
					String str = om.fromOfferToOfferByPartNumber(o).toString();
					strList.add(str);
				}
				response.setTimeTable(strList);
			}
			else {
				response.getTransactionInfo().setStatus(TransactionInfoEnum.NOTFOUND_RESPONSE.getCode());
				response.getTransactionInfo().setErrorMessage(TransactionInfoEnum.NOTFOUND_RESPONSE.getDescription());
			}
		}catch(Exception e) {
			response.getTransactionInfo().setStatus(TransactionInfoEnum.NOTFOUND_RESPONSE.getCode());
			response.getTransactionInfo().setErrorMessage(TransactionInfoEnum.NOTFOUND_RESPONSE.getDescription()+ " " + e.getMessage());
		}
		
		return response;
	}
	
}
