package com.cdac.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.Status;
import com.cdac.entity.Customer;
import com.cdac.exception.CustomerServiceException;
import com.cdac.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {

	@Autowired
	public CustomerService customerService;

	@PostMapping("/register")
	public Status register(@RequestBody Customer customer) {
		try {
			int id = customerService.register(customer);
			Status status = new Status();
			status.setStatus(true);
			status.setStatusMessage("Customer register succesfully!!...");
			status.setCustomerId(id);
			return status;

		} catch (CustomerServiceException e) {

			Status status = new Status();
			status.setStatus(false);
			status.setStatusMessage(e.getMessage());
			return status;
		}

	}
	@PostMapping("/register2")
	public ResponseEntity<Status >register2(@RequestBody Customer customer) {
		
		try {
	int id	= customerService.register(customer);
		Status status = new Status();
		status.setCustomerId(id);
		status.setStatus(true);
		status.setStatusMessage("Customer Register Succesfully in version 2..");
		return new ResponseEntity<Status>(status, HttpStatus.OK) ;
		}catch(CustomerServiceException e) {
			Status status = new Status();
			//status.setCustomerId(id);
			status.setStatus(false);
			status.setStatusMessage("Something error");
			return new ResponseEntity<Status>(status,HttpStatus.BAD_REQUEST);
		}
	}
         @PostMapping("/login")
	    public Status loginCustomer(@RequestBody Customer customer) {
        	        	 
        	 try {
        	 Customer customer1 = customerService.login(customer.getEmail(),customer.getPassword());
        	 Status status = new Status();
        	 status.setStatus(true);
        	 status.setCustomerId(customer1.getId());
        	 status.setStatusMessage("Customer login succesfully");
        	 return status;
        	 }catch(CustomerServiceException e) {
        		 Status status = new Status();
            	 status.setStatus(false);
            	 //status.setCustomerId(customer.getId());
            	 status.setStatusMessage("invalid email and password");
            	 return status;
        	 }
         }
}
