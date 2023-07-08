package webvest.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import webvest.api.model.Investment;

public interface InvestmentRepository extends JpaRepository <Investment, Long> {
	
	List<Investment> findByDescription(String description);
	
	// List<Investment> findByProduct(String product);
	
	List<Investment> findByActive(boolean active);
 
}
