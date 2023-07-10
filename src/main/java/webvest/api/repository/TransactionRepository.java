package webvest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import webvest.api.model.Transaction;

public interface TransactionRepository extends JpaRepository <Transaction, Long>{
	
	

}
