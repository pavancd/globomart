package com.globomart.catalogueservice.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.globomart.catalogueservice.model.Product;
import com.globomart.catalogueservice.services.CatalogueService;

@RestController
@RequestMapping("/catalogue")
public class CatalogueController {

	@Autowired
	private CatalogueService service;

	@Autowired
	RestTemplate restTemplate;

	@PostMapping(path = "/add-product")
	public Long addProduct(@RequestBody Product product) {
		return this.service.addProduct(product);
	}

	@GetMapping(path = "/get-product/{name}")
	public List<Product> getProductByName(@PathVariable(value = "name") String name) {
		return this.service.getProduct(name);

	}

	@DeleteMapping(path = "/delete-product/{id}")
	public void deleteProductById(@PathVariable(value = "id") Long id) {
		this.service.deleteProductById(id);
	}
	
	  @GetMapping("/{productId}")
	  public Double getPrice(@PathVariable(value = "productId") final Long productId) {
	  return this.service.getPrice(productId);
	  }
	  
}
