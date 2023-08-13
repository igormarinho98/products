package webvest.api.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import jakarta.servlet.http.HttpServletResponse;
import webvest.api.config.CsvFileGenerator;
import webvest.api.model.Investment;
import webvest.api.repository.InvestmentRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class InvestmentController {
	
	@Autowired
	 private InvestmentRepository investRepository; 
	
	@Autowired
	private CsvFileGenerator csvGenerator;
	
	@GetMapping("/invest")
	public ResponseEntity<List<Investment>> getAllInvest(@RequestParam(required = false)String description){
		try {
			List<Investment> investList = new ArrayList<Investment>();
			
			if (description == null)
				
				investRepository.findAll().forEach(investList::add);
				
			else 
				investRepository.findByDescription(description).forEach(investList::add);
			
			if (investList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
			}
			return new ResponseEntity<> (investList,HttpStatus.OK);
			
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/investment/{id}")
	private ResponseEntity<Investment> getInvestment(@PathVariable("id") Long id) {
		try {
			Optional<Investment> investment = investRepository.findById(id);
			
			return new ResponseEntity<>(investment.get(), HttpStatus.OK);
			
			
		} catch (Exception e) {
			
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		}
		
	}
	
	@GetMapping("/investment/investors")
	private ResponseEntity<List<Investment>> getInvestorsInvestment() {
		try {
			List<Investment> investmentList = new ArrayList<Investment>();
					
					
					investRepository.findByInvestorExists().forEach(investmentList::add);
			
			return new ResponseEntity<>(investmentList, HttpStatus.OK);
			
			
		} catch (Exception e) {
			
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		}
		
	}
	
	
	
	@PostMapping("/invest")
	public ResponseEntity<Investment> createInvest(@RequestBody Investment invest) {
		try {
			Investment _invest = investRepository
					.save(new Investment(invest.getInvestorId(),  invest.getType(), invest.getInvestedDate(), invest.getValue(), invest.getExpectedreturn(), invest.getInterestRate(), invest.getMaturity(),invest.getStatus(), invest.isActive(),invest.getDescription(), invest.getRescuedate(), invest.getProductId(), invest.getAccnumber()));
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
	
 

	@GetMapping("/invest/my/{investorId}")
	private ResponseEntity<List<Investment>> getInvestmentByInvestor(@PathVariable("investorId") Long id) {
		try {
			List<Investment> investment = new ArrayList<Investment>();
					
					
					investRepository.findInvestmentByInvestor(id).forEach(investment::add);
			
			
			
			return new ResponseEntity<>(investment, HttpStatus.OK);
			
			
		} catch (Exception e) {
			
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		}
		
	}
	
	
	@GetMapping("/invest/export")
	public void exportToCSV(HttpServletResponse response) throws IOException  {
		try {
			List<Investment> investList = new ArrayList<Investment>();
					
					
			investRepository.findAll().forEach(investList::add);
			
			
			
			response.setContentType("text/csv");
			response.addHeader("Content-Disposition", "attachment; filename=\"investimentos.csv\"");
			csvGenerator.writeInvestToCsv(investList, response.getWriter());
		 		
 	
		// generator.generate(response);
		} catch (Exception e){
			 new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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
