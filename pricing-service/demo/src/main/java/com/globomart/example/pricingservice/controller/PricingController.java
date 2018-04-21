package com.globomart.example.pricingservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/pricing")
public class PricingController {
		
	@Autowired
    RestTemplate restTemplate;
	
	  @GetMapping("/{productId}")
	  public Double getStock(@PathVariable("productId") final Long productId) {

	        ResponseEntity<Double> priceResponse = restTemplate.exchange("http://catalogue-service/catalogue/" + productId, HttpMethod.GET,
	                null, new ParameterizedTypeReference<Double>() {
	                });


	        return priceResponse.getBody();
	       
	  }
	      
}
