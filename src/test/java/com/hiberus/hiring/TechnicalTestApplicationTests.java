package com.hiberus.hiring;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.Serializable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hiberus.hiring.infraestructure.controller.OfferController;
import com.hiberus.hiring.infraestructure.service.OfferInfraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
class TechnicalTestApplicationTests implements Serializable{

	private static final long serialVersionUID = -3896664778928550988L;

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private OfferInfraService offerInfraService;

	@InjectMocks
	private OfferController offerController;

	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(offerController).build();
	}

	@Test
	void testCreateOffer() throws Exception {
		String offerRequestJson = "{\"id\":1,\"offer\":{\"brandId\":1,\"productPartnumber\":\"123\"}}";
		mockMvc.perform(MockMvcRequestBuilders.post("/hiberus/api/v1/offer").contentType(MediaType.APPLICATION_JSON).content(offerRequestJson)
				.accept("application/json;charset=UTF-8")).andExpect(status().isCreated());
	
	}

	@Test
	void testGetOffer() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hiberus/api/v1/offer/1").contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept("application/json;charset=UTF-8")).andExpect(status().isOk());
			
	}

	@Test
	void testGetAllOffers() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hiberus/api/v1/offer").accept("application/json;charset=UTF-8"))
				.andExpect(status().isOk());
				
	}
	
	@Test
	void testGetTimeTable() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hiberus/api/v1/brand/1/partnumber/123/offer").accept("application/json;charset=UTF-8"))
				.andExpect(status().isOk());
				
	}


	@Test
	void testDeleteOffer() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/hiberus/api/v1/offer/1").accept("application/json;charset=UTF-8"))
				.andExpect(status().isOk());
				
	}

	@Test
	void testDeleteAllOffers() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/hiberus/api/v1/offer").accept("application/json;charset=UTF-8"))
				.andExpect(status().isOk());
				
	}

	
}
