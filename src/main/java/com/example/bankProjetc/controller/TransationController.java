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

import com.example.bankProjetc.model.Transation;
import com.example.bankProjetc.services.TransationService;

@RestController
public class TransationController {
	@Autowired
	TransationService transatioService;

	@PostMapping("/transaction")
	public ResponseEntity<Transation> createTransation(@RequestBody Transation transation) {
		return new ResponseEntity<Transation>(transatioService.createTranation(transation), HttpStatus.OK);
	}

	@GetMapping("/transations")
	public List<Transation> getAllTransations() {
		return transatioService.findAllTransations();
	}

	@GetMapping("/transactions/{id}")
	public ResponseEntity<Transation> getTransationsById(@PathVariable("id") long TransationId) {
		return new ResponseEntity<Transation>(transatioService.findTransationByTransationId(TransationId),
				HttpStatus.OK);
	}

	@PutMapping("/transation/{id}")
	public ResponseEntity<Transation> updateTransationDetails(@PathVariable("id") long TransationId,
			@RequestBody Transation transation) {
		return new ResponseEntity<Transation>(transatioService.updateTransationDetails(transation, TransationId),
				HttpStatus.OK);
	}

	@DeleteMapping("/transation/{id}")
	public ResponseEntity<String> deleteTransation(@PathVariable("id") long TransationId) {
		transatioService.deleteTransations(TransationId);
		return new ResponseEntity<String>("Transation of given transation id is deleted....", HttpStatus.OK);
	}

}
