package com.hiberus.hiring.infraestructure.adapters.output;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hiberus.hiring.domain.enums.TransactionInfoEnum;
import com.hiberus.hiring.domain.model.Offer;
import com.hiberus.hiring.domain.model.TransactionInfo;
import com.hiberus.hiring.infraestructure.adapters.base.BaseMessage;

/**
 * Response class for hiring exercise
 */
public class OfferResponse extends BaseMessage{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 6708730793631644409L;
	
	@JsonProperty
	private List<Offer> offerList;
	private List<String> timeTable;
	
	public OfferResponse() {
		this.transactionInfo = new TransactionInfo();
		this.getTransactionInfo().setStatus(TransactionInfoEnum.SUCESS_RESPONSE.getCode());
		this.timeTable = new ArrayList<>();
	}

	public List<Offer> getOfferList() {
		return offerList;
	}

	public void setOfferList(List<Offer> offerList) {
		this.offerList = offerList;
	}

	public List<String> getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(List<String> timeTable) {
		this.timeTable = timeTable;
	}

	
	
	
}
