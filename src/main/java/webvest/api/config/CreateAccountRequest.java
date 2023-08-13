package webvest.api.config;

public class CreateAccountRequest {
	
	
	private Long investor;
	
	private double startBalance;

	private Integer agency;
	
	private Integer accnumber;
	
	

	public Integer getAccnumber() {
		return accnumber;
	}

	public void setAccnumber(Integer accnumber) {
		this.accnumber = accnumber;
	}

	public Long getInvestor() {
		return investor;
	}

	public void setInvestor(Long investor) {
		this.investor = investor;
	}

	public double getStartBalance() {
		return startBalance;
	}

	public void setStartBalance(double startBalance) {
		this.startBalance = startBalance;
	}
	
	
	public void setAgency(Integer agency) {
		 this.agency = agency;
	}


	public Integer getAgency() {
		 
		return agency;
	}

}
