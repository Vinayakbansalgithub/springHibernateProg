package com.mvc.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mvc.Entity.Customer;



public interface CustomerDAO {

	@Autowired()
	public List<Customer> getCustomers();
	
	@Autowired()
	public void saveCustomers(Customer customer);
	
	@Autowired()
	public Customer getCustomer(int theId);

	
	@Autowired()
	public void deleteCustomer(int theId);
	
	

	
}
