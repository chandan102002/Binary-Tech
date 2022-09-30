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

import com.example.bankProjetc.Views.CustomerView;
import com.example.bankProjetc.model.Customer;
import com.example.bankProjetc.services.CustomerService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@PostMapping("/customers")
	public Customer saveCustomer(@RequestBody @JsonView(value = CustomerView.post.class) Customer customer) {

		return customerService.saveCustomer(customer);
	}

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long id) {
		return new ResponseEntity<Customer>(customerService.getCustomerById(id), HttpStatus.OK);

	}

	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer, id), HttpStatus.OK);
	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {

        customerService.deleteCustomer(id);
		return new ResponseEntity<String>("Customer deleted successfully", HttpStatus.OK);

	}

}
