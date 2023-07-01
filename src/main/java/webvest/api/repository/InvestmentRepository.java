package webvest.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import webvest.api.model.Investment;

public interface InvestmentRepository extends JpaRepository <Investment, Long> {
	
	List<Investment> findByAccount(Integer account);
	
	List<Investment> findByActive(boolean active);
 
}
