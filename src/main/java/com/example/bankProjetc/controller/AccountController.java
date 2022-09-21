package com.example.bankProjetc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankProjetc.model.Account;
import com.example.bankProjetc.services.AccountService;

@RestController
public class AccountController 
{
	@Autowired
	AccountService accountService;

	@PostMapping("/save")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {

		return new ResponseEntity<Account>(accountService.createAccount(account), HttpStatus.CREATED);
	}

	@GetMapping("/getAccount")
	public List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}

	// http://localhost:8080/get/1
	@GetMapping("/getAccount/{id}")
	public ResponseEntity<Account> getAccountByAccountId(@PathVariable("id") long AccountId) {
		return new ResponseEntity<Account>(accountService.getAccountByAccountId(AccountId), HttpStatus.OK);

	}

	@PutMapping("/updateAccount/{id}")
	public ResponseEntity<Account> updateCustomer(@PathVariable("id") long AccountId, @RequestBody Account account) {
		return new ResponseEntity<Account>(accountService.updateAccount(account, AccountId), HttpStatus.OK);
	}

	@DeleteMapping("/deleteAccount/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable("id") long AccountId) {

		accountService.deleteAccount(AccountId);

		return new ResponseEntity<String>("Your Account is deleted successfully..", HttpStatus.OK);

	}

}
