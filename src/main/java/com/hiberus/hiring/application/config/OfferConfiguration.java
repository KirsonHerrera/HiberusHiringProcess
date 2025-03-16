package com.hiberus.hiring.application.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OfferConfiguration {

  

    @Bean
    ModelMapper modelMapperBean() {
	        return new ModelMapper();
	 }
}
