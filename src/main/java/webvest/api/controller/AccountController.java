package webvest.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

import webvest.api.config.CreateAccountRequest;
import webvest.api.config.UpdateAccountRequest;
import webvest.api.model.Account;
import webvest.api.repository.AccountRepository;
import webvest.api.service.AccountService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class AccountController {
	
	  @Autowired
	    private AccountService accService;
	  
	  @Autowired
	  private AccountRepository accountRepository;

	    @PostMapping("/newAccount")
	    public ResponseEntity<Account> newAccount(@RequestBody CreateAccountRequest request) {
	    	Account account = accService.createAccount(request.getInvestor(), request.getStartBalance(), request.getAgency(), request.getAccnumber());
	        return new ResponseEntity<>(account, HttpStatus.CREATED);
	    }
	    
	    @PostMapping("/updateBalance")
	    public ResponseEntity<Account> updateBal(@RequestBody UpdateAccountRequest request) {
	    	Account account = accService.updateBalance(request.getAccnumber(), request.getAgency(), request.getNewBalance());
	        return new ResponseEntity<>(account, HttpStatus.CREATED);
	    }
	    
	    
	    @PostMapping("/withdrawBalance")
	    public ResponseEntity<Account> withdrawBal(@RequestBody UpdateAccountRequest request) {
	    	Account account = accService.withdrawBalance(request.getAccnumber(), request.getAgency(), request.getNewBalance());
	        return new ResponseEntity<>(account, HttpStatus.CREATED);
	    }
	    
	    

	    @GetMapping("/{id}")
	    public ResponseEntity<Account> searchAccount(@PathVariable UUID id) {
	        Account account = accService.searchById(id);
	        if (account != null) {
	            return new ResponseEntity<>(account, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    @GetMapping("/accounts")
	    public ResponseEntity<List<Account>> AccountList() {
	        try {
	        	
	    	List<Account> accountList = new ArrayList<Account>();
	    	accountRepository.findAll().forEach(accountList::add);  
	    	return new ResponseEntity<>(accountList, HttpStatus.OK);
	    	
	    } catch(Exception e) {
	    	
	    	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	    }
}

