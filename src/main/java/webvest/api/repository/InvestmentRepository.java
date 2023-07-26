package webvest.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import webvest.api.model.Investment;

public interface InvestmentRepository extends JpaRepository <Investment, Long> {
	
	List<Investment> findByDescription(String description);
	
	
	@Query(
			value = "SELECT * FROM public.investments i WHERE i.investor_id > 0", nativeQuery = true)
	List<Investment> findByInvestorExists();
	
	
	List<Investment> findByActive(boolean active);
	
	@Query(			
		value = "SELECT * from public.investments i WHERE i.investor_id = :id ", nativeQuery = true )
		List<Investment> findInvestmentByInvestor(
				@Param("id") Long id);
 
}
