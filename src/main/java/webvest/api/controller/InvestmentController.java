package webvest.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webvest.api.model.Investment;
import webvest.api.repository.InvestmentRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class InvestmentController {
	
	@Autowired
	 InvestmentRepository investRepository; 
	
	@GetMapping("/invest")
	public ResponseEntity<List<Investment>> getAllInvest(@RequestParam(required = false)Integer account){
		try {
			List<Investment> investList = new ArrayList<Investment>();
			
			if (account == null)
				
				investRepository.findAll().forEach(investList::add);
				
			else 
				investRepository.findByAccount(account).forEach(investList::add);
			
			if (investList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<> (investList,HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PostMapping("/invest")
	public ResponseEntity<Investment> createInvest(@RequestBody Investment invest) {
		try {
			Investment _invest = investRepository
					.save(new Investment(invest.getProduct(), invest.getValue(), false, invest.getAccount(), invest.getAgency(), invest.getType()));
			return new ResponseEntity<>(_invest, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/invest/{id}")
	public ResponseEntity<HttpStatus> deleteInvest(@PathVariable("id") long id) {
		try {
			investRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/invest/active")
	public ResponseEntity<List<Investment>> findByActive() {
		try {
			List<Investment> invest = investRepository.findByActive(true);

			if (invest.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(invest, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/invest/inactive")
	public ResponseEntity<List<Investment>> findByInactive() {
		try {
			List<Investment> invest = investRepository.findByActive(false);

			if (invest.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(invest, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
