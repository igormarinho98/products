package webvest.api.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webvest.api.model.Account;
import webvest.api.repository.AccountRepository;

@Service
public class AccountService {

	
	@Autowired
	private AccountRepository accountRepository;
	
	
	public Account createAccount(Long investor, double balanceStart, Integer agency, Integer accnumber) {
		Account newAccount = new Account();
		newAccount.setInvestor(investor);
		newAccount.setBalance(balanceStart);
		newAccount.setAgency(agency);
		newAccount.setAccnumber(accnumber);

		return accountRepository.save(newAccount);
		
	}
	
	public Account searchById(UUID id) {
		return accountRepository.findById(id).orElse(null);
	}
	
	public Account searchByAcc(Integer accnumber, Integer agency) {
		return accountRepository.findByAcc(accnumber, agency).orElse(null);
	}
	
	
	
	public Account updateBalance(Integer accnumber, Integer agency, double newBalance) {
        Account account = searchByAcc(accnumber, agency);
        if (account != null) {
        	newBalance = account.getBalance() + newBalance;
        	account.setBalance(newBalance);
        	accountRepository.save(account);
        }
		return account;
    }
 
	public Account withdrawBalance(Integer accnumber, Integer agency, double newBalance) {
        Account account = searchByAcc(accnumber, agency);
        if (account != null) {
        	newBalance = account.getBalance() - newBalance;
        	account.setBalance(newBalance);
        	accountRepository.save(account);
        }
		return account;
    }
	
	
	
	
	
	
 
}
