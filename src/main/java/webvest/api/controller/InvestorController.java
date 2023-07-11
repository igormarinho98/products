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

import webvest.api.model.Investor;
import webvest.api.repository.InvestorRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class InvestorController {

	
	@Autowired
	private InvestorRepository investorRepository;
	
	
	@PostMapping("/investor")
	public ResponseEntity<Investor> createInvestor(@RequestBody Investor investor) {
		try {
			Investor _investor = investorRepository.save(new Investor(investor.getFirstName(), investor.getLastName(), investor.getBirthday(), investor.getCpf(), investor.getAddress(), investor.getCity(), investor.getState(), investor.getZipCode(), investor.getEmail(), investor.getPhoneNumber(), investor.getPassword()));
			return new ResponseEntity<>(_investor, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping("/investor")
	public ResponseEntity<List<Investor>> getAllInvestors(){
		try {
			List<Investor> listInvestors = new ArrayList<Investor>();
			
			investorRepository.findAll().forEach(listInvestors::add);
			return new ResponseEntity<> (listInvestors, HttpStatus.OK);
			
			
		} catch  (Exception e){
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
