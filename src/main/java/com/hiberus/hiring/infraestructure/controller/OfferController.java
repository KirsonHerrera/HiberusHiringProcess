package com.hiberus.hiring.infraestructure.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.hiberus.hiring.domain.model.Offer;
import com.hiberus.hiring.infraestructure.adapters.input.OfferRequest;
import com.hiberus.hiring.infraestructure.adapters.output.OfferResponse;
import com.hiberus.hiring.infraestructure.service.OfferInfraService;
import com.hiberus.hiring.util.TechnicalTestLogger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Hiberus Hiring API - Cristhian Herrera")
@Controller
@RequestMapping("/hiberus/api/v1")
public class OfferController implements Serializable{

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	transient OfferInfraService offerInfraService;
	

	@Operation(summary = "Get a offer by id", description = "Returns an offer as per the id")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Successfully retrieved"), 
	        @ApiResponse(responseCode = "404", description = "Not found - The product was not found")
	    })
	  @GetMapping(value = "/offer/{offerId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	  @ResponseBody
	  public ResponseEntity<OfferResponse> getOffer(@PathVariable Long offerId){
	    
	        OfferResponse response = offerInfraService.getOffer(new OfferRequest(offerId));
	        return new ResponseEntity<>(response,HttpStatus.OK);
	        		
	  }
	  
	  @Operation(summary = "Get all offers ", description = "Returns all offers in database")
	  @GetMapping(value = "/offer", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	  @ResponseBody
	  public ResponseEntity<OfferResponse> getAllOffers(){
	    
	        OfferResponse response = offerInfraService.getAllOffer();
	        return new ResponseEntity<>(response,HttpStatus.OK);
	        		
	  }
	  

	 @Operation(summary = "Create an offer ", description = "Create an offer an inform us the result")
	 @ApiResponses(value = {
		        @ApiResponse(responseCode = "201", description = "Offer create"), 
		        @ApiResponse(responseCode = "404", description = "Not found - The offer was not found")
		    })
	 @PostMapping(value = "/offer", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	 @ResponseBody
	 public ResponseEntity<OfferResponse> createOffer(@RequestBody OfferRequest request){
		 TechnicalTestLogger.writeLogInfo("requestid "+ request.getId());
		 TechnicalTestLogger.writeLogInfo("request "+ request.getOffer().toString());
		  OfferResponse response = offerInfraService.createOffer(request);
	        return new ResponseEntity<>(response, HttpStatus.CREATED);
	    }
	  
	  
	  @Operation(summary = "Delete offer by id ", description = "Delete a particular offer. Returns transaction info")
	  @DeleteMapping(value = "/offer/{offerId}")
	  @ResponseBody
	  public ResponseEntity<OfferResponse> deleteOffer(@PathVariable Long offerId){
	      OfferResponse response = offerInfraService.deleteOffer(new OfferRequest(offerId));
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }
	    
	  
	  @Operation(summary = "Delete all offers ", description = "Delete all offers. Returns transaction info")
	  @DeleteMapping(value = "/offer", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	  @ResponseBody
	  public ResponseEntity<OfferResponse> deleteOffer(){
	      OfferResponse response = offerInfraService.deleteAllOffer();
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }
	  
	  @Operation(summary = "Return time table information ", description = "Return time table information")
	  @GetMapping(value = "/brand/{brandId}/partnumber/{partnumber}/offer")
	  @ResponseBody
	  public ResponseEntity<OfferResponse> getTimeTable(@PathVariable Integer brandId, @PathVariable String partnumber){
	        
		  	OfferRequest request = new OfferRequest();
		  	Offer offer = new Offer();
		  	offer.setBrandId(brandId);
		  	offer.setProductPartnumber(partnumber);
		  	request.setOffer(offer);
		  	
		  	
	        OfferResponse response = offerInfraService.getTimeTable(request);
	        return new ResponseEntity<>(response,HttpStatus.OK);
	        		
	  }
	
}
