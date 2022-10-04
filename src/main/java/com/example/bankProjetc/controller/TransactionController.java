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

import com.example.bankProjetc.Views.TransactionView;
import com.example.bankProjetc.model.Transaction;
import com.example.bankProjetc.services.TransactionService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class TransactionController {
	@Autowired
	TransactionService transactioService;

	@JsonView(TransactionView.post.class)
	@PostMapping("/transactions")
	public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
		return new ResponseEntity<Transaction>(transactioService.createTransaction(transaction), HttpStatus.OK);
	}

	@JsonView(TransactionView.get.class)
	@GetMapping("/transactions")
	public List<Transaction> getAllTransactions() {
		return transactioService.findAllTransactions();
	}
	
	@JsonView(TransactionView.get.class)
	@GetMapping("/transactions/{id}")
	public ResponseEntity<Transaction> getTransactionById(@PathVariable("id") long TransactionId) {
		return new ResponseEntity<Transaction>(transactioService.getTransactionById(TransactionId), HttpStatus.OK);

	}

	@JsonView(TransactionView.put.class)
	@PutMapping("/transactions/{id}")
	public ResponseEntity<Transaction> updateTransactionDetails(@PathVariable("id") long TransactionId,
			@RequestBody Transaction transaction) {
		return new ResponseEntity<Transaction>(transactioService.updateTransactionDetails(transaction, TransactionId),
				HttpStatus.OK);
	}

	@DeleteMapping("/transactions/{id}")
	public ResponseEntity<String> deleteTransaction(@PathVariable("id") long TransactionId) {
		transactioService.deleteTransactions(TransactionId);
		return new ResponseEntity<String>("Transaction of given id is deleted....", HttpStatus.OK);
	}
}
