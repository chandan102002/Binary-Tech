package com.example.bankProjetc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankProjetc.exception.CustomerNotFoundException;
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
	public Customer getCustomerById(long id) {
		return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer", id));
	}

	@Override
	public Customer updateCustomer(Customer customer, long id) {
		Customer existCustomer = customerRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("Customer", id));

		existCustomer.setId(customer.getId());
		existCustomer.setAccountid(customer.getAccountid());
		existCustomer.setAddress(customer.getAddress());
		existCustomer.setEmail(customer.getEmail());
		existCustomer.setName(customer.getName());
		existCustomer.setPhone(customer.getPhone());
		existCustomer.setAccounts(customer.getAccounts());

		customerRepository.save(existCustomer);
		return existCustomer;

	}

	@Override
	public void deleteCustomer(long id) 
	{
		Customer customer= getCustomerById(id);
		customer.setIsdeleted(true);
		customerRepository.save(customer);
		
		//customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer", id));
		//customerRepository.deleteById(id);
		//customerRepository.deleteCustomer(true);
	}
}
