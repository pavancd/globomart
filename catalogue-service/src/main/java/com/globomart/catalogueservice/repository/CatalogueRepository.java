package com.globomart.catalogueservice.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globomart.catalogueservice.model.Product;

@Repository
@Transactional
public interface CatalogueRepository extends JpaRepository<Product, Long> {

	Product findById(Long id);


	List<Product> findByProductType(String name);

}
