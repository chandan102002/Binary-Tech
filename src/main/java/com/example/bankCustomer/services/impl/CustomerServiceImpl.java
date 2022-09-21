package com.example.bankCustomer.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankCustomer.exception.ResourseNotFoundException;
import com.example.bankCustomer.model.Customer;
import com.example.bankCustomer.repository.CustomerRepository;
import com.example.bankCustomer.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerByCustomerId(long Id) {
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer, long id)
	{
		return null;

	}

	@Override
	public void deleteCustomer(long id) {
	}	 
}
