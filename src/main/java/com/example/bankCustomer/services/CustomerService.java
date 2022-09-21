package com.example.bankCustomer.services;

import java.util.List;

import com.example.bankCustomer.model.Customer;

public interface CustomerService
{
	Customer saveCustomer(Customer customer);
	List<Customer> getAllCustomers();
	Customer getCustomerByCustomerId(long CustomerId);
	Customer updateCustomer(Customer customer, long CustomerId);
	void deleteCustomer(long CustomerId);
	
}
