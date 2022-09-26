package com.example.bankProjetc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankProjetc.exception.TransationNotFoundException;
import com.example.bankProjetc.model.Transation;
import com.example.bankProjetc.repository.TransationRepository;
import com.example.bankProjetc.services.TransationService;

@Service
public class TransationServiceImpl implements TransationService {
	@Autowired
	TransationRepository transationRepo;

	@Override
	public Transation createTranation(Transation transation) {
		return transationRepo.save(transation);
	}

	@Override
	public List<Transation> findAllTransations() {
		return transationRepo.findAll();
	}

	@Override
	public Transation findTransationByTransationId(long TransationId) {
		return transationRepo.findById(TransationId)
				.orElseThrow(() -> new TransationNotFoundException(TransationId, "Transation"));
	}

	@Override
	public Transation updateTransationDetails(Transation transation, long TransationId) {
		Transation existTransation = transationRepo.findById(TransationId)
				.orElseThrow(() -> new TransationNotFoundException(TransationId, "transation"));

		existTransation.setTransation_id(transation.getTransation_id());
		existTransation.setAmout_of_transation(transation.getAmout_of_transation());
		existTransation.setBankaddress(transation.getBankaddress());
		

		return existTransation;
	}

	@Override
	public void deleteTransations(long TransationId) {
		transationRepo.findById(TransationId)
				.orElseThrow(() -> new TransationNotFoundException(TransationId, "transation"));
		transationRepo.deleteById(TransationId);

	}

}
