package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exceptionhandler.CustomerIdInvalidException;
import com.example.demo.exceptionhandler.KeyViolationException;
import com.example.demo.exceptionhandler.ProfileNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	CustomerRepository cusRepo;

	public String customerMembership(Customer customer) {

		Customer customer1 = cusRepo.findByCustomerName(customer.getCustomerName());

		if (customer1 != null) {
			throw new KeyViolationException("Profile is already existed");
		} else {
			cusRepo.save(customer);
			return ("profile created successfully");
		}

	}

	public Optional<Customer> customerView(long customerId) {
		try {
			return Optional.of(cusRepo.findByCustomerId(customerId));
		} catch (Exception e) {
			throw new ProfileNotFoundException("NO SUCH CUSTOMER ID");
		}

	}

	public String modify(Customer customer) {

		Customer customer1 = cusRepo.findByCustomerId(customer.getCustomerId());

		if (customer1 != null) {
			cusRepo.save(customer);
			return "updated successfully";
		} else {
			throw new ProfileNotFoundException("NO SUCH CUSTOMERID WAS REGISTERED");
		}
	}

	/*
	 * public String modify(CustomerRequest customerReq) {
	 * 
	 * Customer customer1 =
	 * cusRepo.findByCustomerName(customerReq.getCustomerName());
	 * 
	 * if(customer1!=null) { customer1.setCustomerAge(customerReq.getCustomerAge());
	 * customer1.setCustomerEmail(customerReq.getCustomerEmail());
	 * customer1.setCustomerMobilenumber(customerReq.getCustomerMobilenumber());
	 * customer1. cusRepo.save(customer1); return "updated successfully"; } else {
	 * throw new ProfileNotFoundException("NO SUCH CUSTOMERNAME WAS REGISTERED"); }
	 * }
	 */
	public String customerDelete(Long id) {

		Customer customer = (cusRepo.findByCustomerId(id));

		if (customer != null) {
			cusRepo.deleteById(id);
			return "Customer is deleted with id " + id;
		} else {
			throw new CustomerIdInvalidException("Customer is not found for this id " + id);
		}

	}
	
	public List<Customer> getAllCustomers(){
		return cusRepo.findAll();
	}
	

}
