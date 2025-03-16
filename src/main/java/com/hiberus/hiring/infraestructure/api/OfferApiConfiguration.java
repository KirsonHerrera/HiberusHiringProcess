package com.hiberus.hiring.infraestructure.api;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ForwardedHeaderFilter;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;

/**
 * API DOC OAS standar
 */
@OpenAPIDefinition
@Configuration
public class OfferApiConfiguration {

    @Bean
    OpenAPI defineOpenApi() {
	       Server server = new Server();
	       server.setUrl("http://localhost:8080");
	       server.setDescription("Development");

	       Contact myContact = new Contact();
	       myContact.setName("Cristhian Herrera");
	       myContact.setEmail("cristhian.herrera@gmail.com");

	       Info information = new Info()
	               .title("Hiberus selection process")
	               .version("1.0")
	               .description("This API exposes endpoints to manage offers in technical test.")
	               .contact(myContact);
	       return new OpenAPI().info(information).servers(List.of(server));
	   }
    
    @Bean
    ForwardedHeaderFilter forwardedHeaderFilter() {
       return new ForwardedHeaderFilter();
    }
}
