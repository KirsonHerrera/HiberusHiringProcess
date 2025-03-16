package com.hiberus.hiring.application.validator;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Date;

import com.hiberus.hiring.application.dto.DateComparatorDTO;
import com.hiberus.hiring.domain.model.Offer;

/**
 * Validator date
 */
public class OfferDateValidator {

	/**
	 * Validate if the object has a valid range
	 * @param obj
	 * @return
	 */
	public Boolean dateRangeOk(Offer obj) {
		Boolean res = false;
		
		String sDate = obj.getStartDate();
		Timestamp ts = Timestamp.from(Instant.parse(obj.getEndDate()));
		    
		OffsetDateTime odt = OffsetDateTime.parse(sDate);
		res = odt.toInstant().isBefore(ts.toInstant());
		
		return res;
	}
	
	/**
	 * Convert string ISO to DaTE
	 * @param dateISO
	 * @return
	 */
	public Date fromISO8601toDate(String dateISO) {
		Timestamp ts = Timestamp.from(Instant.parse(dateISO));
	    
		
		return new Date(ts.getTime());

	}
	
	/**
	 * Validate if the object has a valid range
	 * @param obj
	 * @return
	 */
	public DateComparatorDTO dateRangeRangeOverlap(Offer current, Offer compareOffer) {
		
		DateComparatorDTO res = new DateComparatorDTO();
		
		Date startA = fromISO8601toDate(current.getStartDate());
		Date startB = fromISO8601toDate(compareOffer.getStartDate());
		
		Date endA = fromISO8601toDate(current.getEndDate());
		Date endB = fromISO8601toDate(compareOffer.getEndDate());
		
		boolean overlap = rangesOverlap(startA, endA, startB, endB);
		
		if(overlap) {
			res.setIsDateOverlap(true);
			res.setCurrenOffer(current);
			res.setOverloadOffer(compareOffer);
		}
		
		return res;
		
	
	}
	
	/**
	 * Compare dateRange
	 * To more information, review source in 
	 * https://es.stackoverflow.com/questions/540328/c%C3%B3mo-determinar-si-dos-rangos-de-fechas-se-solapan-en-java
	 * @param startA
	 * @param endA
	 * @param startB
	 * @param endB
	 * @return
	 */
	public boolean rangesOverlap(Date startA, Date endA, Date startB, Date endB) {
	    return startA.getTime() <= endB.getTime() && startB.getTime() <= endA.getTime();
	}
}
