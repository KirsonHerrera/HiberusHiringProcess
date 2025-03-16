package com.hiberus.hiring.exception;

public class OfferNotFoundException  extends Exception{

	/**
	 * Default serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	 /**
	  * Override super constructor
	  * @param msg
	  */
	public OfferNotFoundException(String msg) {
		super(msg);
	}

}
