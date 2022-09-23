package com.example.bankProjetc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bankProjetc.model.Transation;

@Repository
public interface TransationRepository extends JpaRepository<Transation, Long> {
}
