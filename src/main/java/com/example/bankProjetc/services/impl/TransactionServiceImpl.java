package com.example.bankProjetc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankProjetc.exception.TransactionNotFoundException;
import com.example.bankProjetc.model.Transaction;
import com.example.bankProjetc.repository.TransactionRepository;
import com.example.bankProjetc.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	TransactionRepository transactionRepo;

	@Override
	public Transaction createTransaction(Transaction transaction) {
		return transactionRepo.save(transaction);
	}

	@Override
	public List<Transaction> findAllTransactions() {
		return transactionRepo.findAll();
	}

	@Override
	public Transaction getTransactionById(long Id) {
		return transactionRepo.findById(Id).orElseThrow(() -> new TransactionNotFoundException(Id, "Transation"));
	}

	@Override
	public Transaction updateTransactionDetails(Transaction transaction, long Id) {
		Transaction existTransaction = transactionRepo.findById(Id)
				.orElseThrow(() -> new TransactionNotFoundException(Id, "transation"));

		existTransaction.setId(transaction.getId());
		existTransaction.setDate(transaction.getDate());
		existTransaction.setAmout(transaction.getAmout());
		existTransaction.setBankaddress(transaction.getBankaddress());

		return existTransaction;
	}

	@Override
	public void deleteTransactions(long Id) {
		transactionRepo.findById(Id).orElseThrow(() -> new TransactionNotFoundException(Id, "transation"));
		transactionRepo.deleteById(Id);

	}

}
