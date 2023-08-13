package webvest.api.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import webvest.api.model.Account;
import webvest.api.model.Investment;

public interface AccountRepository extends JpaRepository<Account, UUID> {

	 
	@Query(value = "SELECT * from public.accounts p WHERE p.accnumber = :accnumber AND p.agency = :agency  ", nativeQuery = true )
			Optional<Account> findByAcc(
					@Param("accnumber") Integer accnumber, Integer agency);
			
			
			
}


