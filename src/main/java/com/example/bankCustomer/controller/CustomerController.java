package com.example.bankCustomer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankCustomer.model.Customer;
import com.example.bankCustomer.services.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;

	// build create employee REST API
	@PostMapping("/post")
	public ResponseEntity<Customer> saveEmployee(@RequestBody Customer employee) {

		return new ResponseEntity<Customer>(customerService.saveCustomer(employee), HttpStatus.CREATED);
	}

	// building get all employees rest api
	@GetMapping("/get")
	public List<Customer> getAllEmployees() {
		return customerService.getAllCustomers();
	}

}
