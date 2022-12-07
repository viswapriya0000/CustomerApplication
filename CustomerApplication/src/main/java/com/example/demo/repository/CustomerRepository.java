package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

	public Customer findByCustomerName(String customerName);
	public Customer findByCustomerId(Long id);
}
