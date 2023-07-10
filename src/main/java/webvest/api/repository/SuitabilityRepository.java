package webvest.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import webvest.api.model.Suitability;

public interface SuitabilityRepository extends JpaRepository <Suitability, Long>{
	
	Optional<Suitability> findById(Long id);

}
