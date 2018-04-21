package com.globomart.catalogueservice.exceptions;

public class ProductNotFoundException extends RuntimeException {
	
	public ProductNotFoundException(String message) {
		super(message);
	}
}
