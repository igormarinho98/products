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
	
	
	public Account createAccount(Long investor, double balanceStart) {
		Account newAccount = new Account();
		newAccount.setInvestor(investor);
		newAccount.setBalance(balanceStart);
		return accountRepository.save(newAccount);
		
	}
	
	public Account searchById(UUID id) {
		return accountRepository.findById(id).orElse(null);
	}
	
	public void updateBalance(UUID id, double newBalance) {
        Account account = searchById(id);
        if (account != null) {
        	account.setBalance(newBalance);
        	accountRepository.save(account);
        }
    }

	
	
	
	
	
	
 
}
