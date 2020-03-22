package com.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.Dao.CustomerDAO;
import com.mvc.Entity.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	CustomerServiceImpl(){
		System.out.println("CustomerServiceImpl is called");
	}
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}
	
	@Override
	@Transactional
	public void saveCustomers(Customer customer) {
		 customerDAO.saveCustomers(customer);
	}
	
	
	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		return customerDAO.getCustomer(theId);
	}
	
	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		customerDAO.deleteCustomer(theId);
	}
	
}





