package com.cdac.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.entity.Customer;
import com.cdac.exception.CustomerServiceException;
import com.cdac.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	public CustomerRepository customerRepository;

	public int register(Customer customer) {

		Optional<Customer> customerCheck = customerRepository.findByEmail("email");
		if (customerCheck.isEmpty()) {

		Customer savedCustomer = customerRepository.save(customer);
		return savedCustomer.getId();
		} else
			throw new CustomerServiceException("Customer already register");
	}
	
	public Customer login(String email, String password) {
		Optional<Customer> customer = customerRepository.findByEmailAndPassword(email, password);
		if(customer.isPresent())
			
		return customer.get();
		else
			throw new CustomerServiceException("invalid login and password");
	}

}
