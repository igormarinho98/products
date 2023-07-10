package webvest.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "investments")
@Entity
public class Investment { 	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "investor_id")
	private Long investor_id;
	
	 
	@Column(name = "type")
	private String type;
	
	@Column(name = "investment_date")
	private String investment_date;

	@Column(name = "invested_amount")
	private double invested_amount;
	
	@Column(name = "expected_return")
	private double expected_return;
	
	@Column(name = "interest_rate")
	private double interest_rate;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "description")
	private String description;
	
	
	@Column(name = "active")
	private boolean active;
	
	 
	@Column(name = "maturity_period")
	private Integer maturity_period;
	
	
	
	public Investment(Long investor_id, String type, String investment_date, double invested_amount, double expected_return,  double interest_rate, Integer maturity_period, String status,boolean active,    String description) {
		
		this.investor_id = investor_id;
		this.type = type;
		this.investment_date = investment_date;
		this.invested_amount = invested_amount;
		this.expected_return = expected_return;
		this.interest_rate = interest_rate;
		this.maturity_period = maturity_period;
		this.status = status;
		this.active = active;
		this.description = description;

		
	}
		
	public double getExpectedreturn() {
		return expected_return;
	}

	public double getInterestRate() {
		return interest_rate;
	}

	public void setInterestRate(double interest_rate) {
		this.interest_rate = interest_rate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setExpectedreturn(Integer expected_return) {
		this.expected_return = expected_return;
	}

	public String getInvestedDate() {
		return investment_date;
	}

	public void setInvesteddate(String investment_date) {
		this.investment_date = investment_date;
	}

	public Investment() {
			
		}

	public Long getId() {
		return id;
	}

	 

	public Long getInvestorId() {
		return investor_id;
	}

	public void setnvestorId(Long investor_id) {
		this.investor_id = investor_id;
	}

	public double getValue() {
		return invested_amount;
	}

	public void setValue(double value) {
		this.invested_amount = value;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	  
	public int getMaturity() {
		return maturity_period;
	}

	public void setMaturity(int agency) {
		this.maturity_period = agency;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
		
	
	

}
