package webvest.api.model;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Accounts")
public class Account {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;

	@Column(name = "balance")
	private double balance;

	@Column(name = "investor")
	private Long investor;
	

	@Column(name = "agency")
	private Integer agency;
	
	@Column(name = "accnumber")
	private Integer accnumber;

	

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Long getInvestor() {
		return investor;
	}

	public void setInvestor(Long investor) {
		this.investor = investor;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	public Integer getAgency() {
		return agency;
	}
	
	public void setAgency(Integer agency) {
		this.agency = agency;
	}
	
	public Integer getAccnumber() {
		return accnumber;
	}
	
	public void setAccnumber(Integer accnumber) {
		this.accnumber = accnumber;

	
	}
}
