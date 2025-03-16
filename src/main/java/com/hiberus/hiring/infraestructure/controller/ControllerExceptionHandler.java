package com.hiberus.hiring.infraestructure.controller;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hiberus.hiring.exception.OfferNotFoundException;
import com.hiberus.hiring.exception.InvalidOfferRequestException;
import com.hiberus.hiring.util.TechnicalTestLogger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

	
	@ResponseStatus(HttpStatus.NOT_FOUND) // 404
	  @ExceptionHandler(OfferNotFoundException.class)
	  public void handleNotFound(OfferNotFoundException ex) {
		TechnicalTestLogger.writeLogError("Requested account not found");
	  }

	  @ResponseStatus(HttpStatus.BAD_REQUEST) // 400
	  @ExceptionHandler(InvalidOfferRequestException.class)
	  public void handleBadRequest(InvalidOfferRequestException ex) {
		  TechnicalTestLogger.writeLogError("Invalid account supplied in request");
	  }

	  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
	  @ExceptionHandler(Exception.class)
	  public void handleGeneralError(Exception ex) {
		  TechnicalTestLogger.writeLogError("An error occurred processing request" + ex);
	  }
}
