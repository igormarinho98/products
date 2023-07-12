package webvest.api.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import webvest.api.config.CsvFileGenerator;
import webvest.api.model.Transaction;
import webvest.api.repository.TransactionRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private CsvFileGenerator csvGenerator;
	
	
	
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
	
	@GetMapping("/transaction/{id}")
	private ResponseEntity<Transaction> getTransaction(@PathVariable("id") Long id) {
		try {
			Optional<Transaction> transaction = transactionRepository.findById(id);
			
			return new ResponseEntity<>(transaction.get(), HttpStatus.OK);
			
			
		} catch (Exception e) {
			
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		}
		
	}
	
	@GetMapping("/transaction/export")
	public void exportToCSV(HttpServletResponse response) throws IOException  {
		try {
			List<Transaction> transactionList = new ArrayList<Transaction>();
					
					
			transactionRepository.findAll().forEach(transactionList::add);
			
			
			
			response.setContentType("text/csv");
			response.addHeader("Content-Disposition", "attachment; filename=\"transactions.csv\"");
			csvGenerator.writeTransactionsToCsv(transactionList, response.getWriter());
		 		
 	
		// generator.generate(response);
		} catch (Exception e){
			 new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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
