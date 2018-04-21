package com.globomart.catalogueservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globomart.catalogueservice.exceptions.ProductNotFoundException;
import com.globomart.catalogueservice.model.Product;
import com.globomart.catalogueservice.repository.CatalogueRepository;

@Service
public class CatalogueService {
	
	@Autowired
	private CatalogueRepository repository;

	public Long addProduct(Product product) {
		this.repository.save(product);
		return product.getId();
	}

	public List<Product> getProduct(String type) {
		List<Product> list = this.repository.findByProductType(type);
		if(list == null) throw new ProductNotFoundException("No Product with the given type");
		return list;
	}

	public void deleteProductById(Long id) {
		Product product = this.repository.findById(id);
		if(product == null)  throw new ProductNotFoundException("No Product with the given id");
		this.repository.delete(id);
	}

	public Double getPrice(Long productId) {
		 Product product =  this.repository.findById(productId);
		 if(product == null)  throw new ProductNotFoundException("No Product with the given id");
			return product.getPrice();
		 
	}

}
