package webvest.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webvest.api.model.Transaction;
import webvest.api.repository.TransactionRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	
	
	@GetMapping("/transaction")
	private ResponseEntity<List<Transaction>> getAllTrnsaction() {
		try {
			List<Transaction> transactionList = new ArrayList<Transaction>();
						
			transactionRepository.findAll().forEach(transactionList::add);
			
			return new ResponseEntity<>(transactionList, HttpStatus.OK);
			
		} catch (Exception e) {
			
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	
	
	@PostMapping("/transaction")
	private ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
		try {
			Transaction _transaction = transactionRepository
					.save(new Transaction(transaction.getInvestmentId(),transaction.getTransactionDate(), transaction.getTransactionAmount(), transaction.getTransactionType() ,transaction.getDescription()));
			return new ResponseEntity<>(_transaction, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
			
		}
		
	}
	
	

}
