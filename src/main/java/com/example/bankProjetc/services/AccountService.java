package com.example.bankProjetc.services;

import java.util.List;
import com.example.bankProjetc.model.Account;

public interface AccountService
{
	Account createAccount(Account account);
	List<Account> getAllAccounts();
	Account getAccountByAccountId(long AccountId);
	Account updateAccount(Account account, long AccountId);
	void deleteAccount(long AccountId);
	
}
