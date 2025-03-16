package com.hiberus.hiring.exception;

public class OfferWithDateOverlapException extends Exception {

	 /**
	 * Serial version
	 */
	private static final long serialVersionUID = 5890900224649594809L;

	/**
	  * Override super constructor
	  * @param msg
	  */
	public OfferWithDateOverlapException(String msg) {
		super(msg);
	}

}
