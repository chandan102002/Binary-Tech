package com.example.bankProjetc.services;

import java.util.List;

import com.example.bankProjetc.model.Transaction;

public interface TransactionService {
	Transaction createTransaction(Transaction transaction);

	List<Transaction> findAllTransactions();

	Transaction getTransactionById(long Id);

	Transaction updateTransactionDetails(Transaction transaction, long Id);

	void deleteTransactions(long Id);
}
