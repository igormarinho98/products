package webvest.api.config;

public class CreateAccountRequest {
	
	
	private Long investor;
	
	private double startBalance;

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

}
