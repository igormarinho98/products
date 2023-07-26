package webvest.api.controller;

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

import webvest.api.model.Investor;
import webvest.api.model.Transaction;
import webvest.api.repository.InvestorRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class InvestorController {

	
	@Autowired
	private InvestorRepository investorRepository;
	
	
	@PostMapping("/investor")
	public ResponseEntity<Investor> createInvestor(@RequestBody Investor investor) {
		try {
			Investor _investor = investorRepository.save(new Investor(investor.getFirstName(), investor.getLastName(), investor.getBirthday(), investor.getCpf(), investor.getAddress(), investor.getCity(), investor.getState(), investor.getZipCode(), investor.getEmail(), investor.getPhoneNumber(), investor.getPassword(), investor.getSuitability()));
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
	
	
	@GetMapping("/investor/{id}")
	private ResponseEntity<Investor> getInvestor(@PathVariable("id") Long id) {
		try {
			Optional<Investor> investor = investorRepository.findById(id);
			
			return new ResponseEntity<>(investor.get(), HttpStatus.OK);
			
			
		} catch (Exception e) {
			
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		}
		
	}
	
}
