package webvest.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import webvest.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByActive(boolean active);

	  List<Product> findByNameContaining(String name);
	  
	  

}
