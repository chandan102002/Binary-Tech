package com.example.bankProjetc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankProjetc.exception.AccountNotFoundException;
import com.example.bankProjetc.model.Account;
import com.example.bankProjetc.repository.AccountRepository;
import com.example.bankProjetc.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepository accountRepo;

	@Override
	public Account createAccount(Account account) {

		return accountRepo.save(account);
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountRepo.findAll();
	}

	@Override
	public Account getAccountByAccountId(long AccountId) {

		return accountRepo.findById(AccountId).orElseThrow(() -> new AccountNotFoundException(AccountId, "Account"));
	}

	@Override
	public Account updateAccount(Account account, long AccountId) {
		Account existAccount = accountRepo.findById(AccountId)
				.orElseThrow(() -> new AccountNotFoundException(AccountId, "Account"));

		existAccount.setId(account.getId());
		existAccount.setCurrentBalance(account.getCurrentBalance());
		existAccount.setOpeningDate(account.getOpeningDate());
		existAccount.setCustomers(account.getCustomers());
		existAccount.setBankaddress(account.getBankaddress());
		return existAccount;
	}

	@Override
	public void deleteAccount(long AccountId) {
		accountRepo.findById(AccountId).orElseThrow(() -> new AccountNotFoundException(AccountId, "Account"));
		accountRepo.deleteById(AccountId);
	}

}
