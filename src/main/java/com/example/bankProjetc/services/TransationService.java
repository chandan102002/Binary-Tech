package com.example.bankProjetc.services;

import java.util.List;

import com.example.bankProjetc.model.Transation;

public interface TransationService 
{
	Transation createTranation(Transation transation);
	List<Transation>findAllTransations();
	Transation findTransationByTransationId(long TransationId);
	Transation updateTransationDetails(Transation transation, long TransationId);
	void deleteTransations(long TransationId);
}
