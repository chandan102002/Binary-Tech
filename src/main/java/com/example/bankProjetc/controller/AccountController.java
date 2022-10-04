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

import com.example.bankProjetc.Views.AccountView;
import com.example.bankProjetc.model.Account;
import com.example.bankProjetc.services.AccountService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class AccountController {
	@Autowired
	AccountService accountService;

	@JsonView(value = AccountView.post.class)
    @PostMapping("/accounts")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {

		return new ResponseEntity<Account>(accountService.createAccount(account), HttpStatus.CREATED);
	}

	@JsonView(value = AccountView.get.class)
	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}

	@JsonView(value= AccountView.get.class)
	@GetMapping("/accounts/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable("id") long Id) {
		return new ResponseEntity<Account>(accountService.getAccountById(Id), HttpStatus.OK);

	}

	@JsonView(value= AccountView.put.class)
	@PutMapping("/accounts/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable("id") long AccountId, @RequestBody Account account) {
		return new ResponseEntity<Account>(accountService.updateAccount(account, AccountId), HttpStatus.OK);
	}

	@DeleteMapping("/accounts/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable("id") long Id) {

		accountService.deleteAccount(Id);

		return new ResponseEntity<String>("Your Account is deleted successfully..", HttpStatus.OK);

	}

}
