package com.example.bankProjetc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bankProjetc.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}