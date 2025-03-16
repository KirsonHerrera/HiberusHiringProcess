package com.hiberus.hiring.domain.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.hiring.domain.enums.TransactionInfoEnum;
import com.hiberus.hiring.domain.model.TransactionInfo;
import com.hiberus.hiring.domain.persistence.entity.OfferEntity;
import com.hiberus.hiring.domain.persistence.repository.OfferRepository;

import jakarta.transaction.Transactional;

/**
 * Offer service at persistence level
 */
@Service
public class OfferPersistenceService {

	@Autowired
	private OfferRepository offerRepository;
	
	/**
	 * Get all offers
	 * @return
	 */
	public List<OfferEntity> getOffers() {
		return offerRepository.findAll();
	}
	
	/**
	 * Persist and offer
	 * @param obj
	 * @return
	 */
	@Transactional
	public OfferEntity save(OfferEntity obj) {
		return offerRepository.save(obj);
	}
	
	/**
	 * Delete an offer
	 * @param obj
	 * @return
	 */
	@Transactional
	public TransactionInfo delete(OfferEntity obj) {
		TransactionInfo ti = new TransactionInfo();
		
		try {
			
						
			offerRepository.delete(obj);
			
			ti.setStatus(TransactionInfoEnum.SUCESS_RESPONSE.getCode());
			ti.setStatus(TransactionInfoEnum.SUCESS_RESPONSE.getDescription());
			
		}catch(Exception e) {
			
		  ti.setErrorMessage(TransactionInfoEnum.ERROR_RESPONSE.getCode());
		  ti.setErrorMessage(e.getMessage());
		}
		
		return ti;
	}
	
	/**
	 * Delete all offers
	 * @return
	 */
	@Transactional
	public TransactionInfo deleteAll() {
		TransactionInfo ti = new TransactionInfo();
		
		try {
			
						
			offerRepository.deleteAll();
			
			ti.setStatus(TransactionInfoEnum.SUCESS_RESPONSE.getCode());
			ti.setStatus(TransactionInfoEnum.SUCESS_RESPONSE.getDescription());
			
		}catch(Exception e) {
			
		  ti.setErrorMessage(TransactionInfoEnum.ERROR_RESPONSE.getCode());
		  ti.setErrorMessage(e.getMessage());
		}
		
		return ti;
	}
	
	/**
	 * Find an offer by ID
	 * @param id
	 * @return
	 */
	public Optional<OfferEntity> findById(Long id) {
	
		return offerRepository.findById(id);
	}
		
	public List<OfferEntity> findAll(){
		
		return offerRepository.findAll();
	}
	
	public List<OfferEntity> findByBrandId(Integer brandId){
		
		return offerRepository.findByBrandId(brandId);
	}
	
	public List<OfferEntity> findByBrandIdAndPartnumber(Integer brandId, String partnumber){
		
		return offerRepository.findByBrandIdAndProductPartnumber(brandId,partnumber);
	}
}
