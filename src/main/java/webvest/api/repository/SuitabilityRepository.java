package webvest.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import webvest.api.model.Suitability;

public interface SuitabilityRepository extends JpaRepository <Suitability, Long>{
	
///	List<Suitability> findByInvestorId(Long investor_id);

}
