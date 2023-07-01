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
	
	@Column(name = "product")
	private String product;
	
	 
	@Column(name = "value")
	private double value;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "account")
	private int account;
	
	@Column(name = "agency")
	private int agency;
	
	@Column(name = "type")
	private String type;
	
	
	
	public Investment(String product, double value, boolean active, int account, int agency, String type) {
		
		this.product = product;
		this.value = value;
		this.active = active;
		this.account = account;
		this.agency = agency;
		this.type = type;
		
	}
		
	public Investment() {
			
		}

	public Long getId() {
		return id;
	}

	 

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public int getAgency() {
		return agency;
	}

	public void setAgency(int agency) {
		this.agency = agency;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
		
	
	

}
