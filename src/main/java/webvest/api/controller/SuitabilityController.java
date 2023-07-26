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
import org.springframework.web.bind.annotation.RestController;

import webvest.api.model.Suitability;
import webvest.api.repository.SuitabilityRepository;



	@RestController
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping("/api")
	public class SuitabilityController {
	
		@Autowired
		private SuitabilityRepository suitabilityRepository;
		
		@GetMapping("/suitability")
		public ResponseEntity<List<Suitability>> getAllSuit() {
			try {
				List<Suitability> suitList = new ArrayList<Suitability>();
				suitabilityRepository.findAll().forEach(suitList::add);
				
				return new ResponseEntity<>(suitList, HttpStatus.OK);
				
				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}
		
		@PostMapping("/suitability")
		public ResponseEntity<Suitability> createSuitability(@RequestBody Suitability suitability) {
			try {
			Suitability _suitability = suitabilityRepository.save(new Suitability(suitability.getProfile(), suitability.getDescription(), suitability.getRegisterDate()));
			return new ResponseEntity<>(_suitability, HttpStatus.CREATED); 
			
			} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);	
			}
			
		}
			

		@DeleteMapping("/suitability/{id}")
		public ResponseEntity<HttpStatus> deleteSuitability(@PathVariable("id")Long id){
			try { 
				suitabilityRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				  
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
		}
		
		
		
		
				
		
			

}
