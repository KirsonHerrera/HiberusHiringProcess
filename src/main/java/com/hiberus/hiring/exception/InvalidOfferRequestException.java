package com.hiberus.hiring.exception;

public class InvalidOfferRequestException extends Exception {

	
	 /**
	 * Serial version
	 */
	private static final long serialVersionUID = 3034730983908708991L;

	/**
	  * Override super constructor
	  * @param msg
	  */
	public InvalidOfferRequestException(String msg) {
		super(msg);
	}
}
