package webvest.api.config;

import java.util.UUID;

public class UpdateAccountRequest {

	private	Integer accnumber;
	
	
	private	Integer agency;
	
	private double newBalance;
	
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

	public double getNewBalance() {
		return newBalance;
	}

	public void setNewBalance(double newBalance) {
		this.newBalance = newBalance;
	}
	
	
	
	
}
