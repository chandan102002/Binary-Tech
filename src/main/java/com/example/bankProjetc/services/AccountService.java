package com.example.bankProjetc.services;

import java.util.List;
import com.example.bankProjetc.model.Account;

public interface AccountService {
	Account createAccount(Account account);

	List<Account> getAllAccounts();

	Account getAccountById(long Id);

	Account updateAccount(Account account, long Id);

	void deleteAccount(long Id);

}
