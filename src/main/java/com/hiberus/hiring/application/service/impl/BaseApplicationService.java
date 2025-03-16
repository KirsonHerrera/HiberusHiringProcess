package com.hiberus.hiring.application.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.hiberus.hiring.application.adapters.mapper.OfferMapper;
import com.hiberus.hiring.domain.persistence.service.OfferPersistenceService;

@Service
public class BaseApplicationService {

	@Autowired 
	protected OfferPersistenceService offerPersistence;
	
	@Autowired
	protected ModelMapper mapper;
	

    protected OfferMapper offerMapper = new OfferMapper(mapper);
}
