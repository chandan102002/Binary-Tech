package com.example.bankProjetc.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankProjetc.exception.ResourseNotFoundException;
import com.example.bankProjetc.model.Customer;
import com.example.bankProjetc.repository.CustomerRepository;
import com.example.bankProjetc.services.CustomerService;

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
	public Customer getCustomerByCustomerId(long id) {
		return customerRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Customer", id));
	}

	@Override
	public Customer updateCustomer(Customer customer, long id) {
		Customer existCustomer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Customer", id));

		existCustomer.setCustomer_Id(customer.getCustomer_Id());
		existCustomer.setAccID(customer.getAccID());
		existCustomer.setAddress(customer.getAddress());
		existCustomer.setEmail(customer.getEmail());
		existCustomer.setName(customer.getName());
		existCustomer.setPhone(customer.getPhone());
	

		// save existing employee to db
		customerRepository.save(existCustomer);
		return existCustomer;

	}

	@Override
	public void deleteCustomer(long id) 
	{
		customerRepository.findById(id).orElseThrow(()->new ResourseNotFoundException("Customer", id));
		customerRepository.deleteById(id);
	}
}
