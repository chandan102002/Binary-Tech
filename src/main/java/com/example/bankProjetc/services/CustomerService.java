package com.example.bankProjetc.services;

import java.util.List;

import com.example.bankProjetc.model.Customer;

public interface CustomerService {
	Customer saveCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerById(long Id);

	Customer updateCustomer(Customer customer, long Id);

	void deleteCustomer(long Id);

}
