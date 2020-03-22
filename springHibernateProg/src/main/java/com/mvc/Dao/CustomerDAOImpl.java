package com.mvc.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.Entity.Customer;




@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private  SessionFactory sessionFactory;
	
	
	CustomerDAOImpl(){
		System.out.println("CustomerDAOImpl constructor is called");
	}
			
	@Override
	//@Transactional
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();	
		// create a query
				Query<Customer> theQuery = 
						currentSession.createQuery("from Customer order by firstName", Customer.class);
				
				// execute query and get result list
				List<Customer> customers = theQuery.getResultList();

		// return the results		
		return customers;
	}
	
	@Override
	//@Transactional
	public void saveCustomers(Customer customer) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();	
		
		
		//currentSession.save(customer);
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(customer);

		
	}
	
	
	@Override
	public Customer getCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}
	
	@Override
	public void deleteCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();		
	}
	
}






