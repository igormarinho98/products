package webvest.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "investment_id")
	private Integer investment_id;

	@Column(name = "transaction_date")
	private String transaction_date;
	
	@Column(name = "transaction_amount")
	private double transaction_amount;
	
	@Column(name = "transaction_type")
	private String transaction_type;
	
	@Column(name = "description")
	private String description;
	
	public Transaction() {
		
	}
	

	public Transaction (Integer investment_id, String transaction_date, double transaction_amount, String transaction_type, String description  ) {
	
	this.investment_id = investment_id;
	this.transaction_date = transaction_date;
	this.transaction_amount = transaction_amount;
	this.transaction_type = transaction_type;
	this.description = description;
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getInvestmentId() {
		return investment_id;
	}


	public void setInvestmentId(Integer investment_id) {
		this.investment_id = investment_id;
	}


	public String getTransactionDate() {
		return transaction_date;
	}


	public void setTransactionDate(String transaction_date) {
		this.transaction_date = transaction_date;
	}


	public double getTransactionAmount() {
		return transaction_amount;
	}


	public void setTransactionAmount(double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}


	public String getTransactionType() {
		return transaction_type;
	}


	public void setTransactionType(String transaction_type) {
		this.transaction_type = transaction_type;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
}
