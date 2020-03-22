package com.mvc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.Dao.CustomerDAOImpl;
import com.mvc.Entity.Customer;
import com.mvc.service.CustomerServiceImpl;




@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer dao
//	@Autowired
//	private CustomerDAOImpl customerDAO;
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	
	CustomerController(){
		System.out.println("CustomerControllers constructor is called");
	}
	
//	@RequestMapping("/list")
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
				
		// get customers from the dao
		//List<Customer> theCustomers = customerDAO.getCustomers();
		List<Customer> theCustomers = customerServiceImpl.getCustomers();

				
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String AddCustomers(Model theModel) {
				
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customerAdd", theCustomer);
		
		
		return "newCustomerForm";
	}
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customerAdd") Customer theCustomer) {
		
		// save the customer using our service
		customerServiceImpl.saveCustomers(theCustomer);
		
		
		
		return "redirect:/customer/list";
	}
	

	
	// add mapping for POST /customers  - add new customer
	
		@PostMapping("/customers")
		public Customer addCustomer(@RequestBody Customer theCustomer) {
			
			// also just in case the pass an id in JSON ... set id to 0
			// this is force a save of new item ... instead of update
			
			//theCustomer.setId(0);
			
			customerServiceImpl.saveCustomers(theCustomer);
			
			return theCustomer;
		}
		
			
		// add mapping for PUT /customers - update existing customer
		
		@PutMapping("/customers")
		public Customer updateCustomer(@RequestBody Customer theCustomer) {
			
			customerServiceImpl.saveCustomers(theCustomer);
			
			return theCustomer;
			
		}
		
		// add mapping for DELETE /customers/{customerId} - delete customer
		
		@DeleteMapping("/customers/{customerId}")
		public String deleteCustomer(@PathVariable int customerId) throws Exception {
			
			Customer tempCustomer = customerServiceImpl.getCustomer(customerId);
			
			// throw exception if null
			
			if (tempCustomer == null) {
				throw new Exception("Customer id not found - " + customerId);
			}
					
			customerServiceImpl.deleteCustomer(customerId);
			
			return "Deleted customer id - " + customerId;
		}
		
}


