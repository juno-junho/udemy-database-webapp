package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // need to inject the customer dao
//    @Autowired
//    private CustomerDAO customerDAO; 
	
	// need to inject our customer service
	@Autowired
	private CustomerService customerService;
	
    @GetMapping("/list")
    public String listCustomers(Model theModel){
        // get the customers from the dao
//        List<Customer> theCustomers = customerDAO.getCustomers();
    	
//    	 get the customers from the service
    	// Delegate call to service
    	List<Customer> theCustomers = customerService.getCustomers();

        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);
        return "list-customers";
    }
    
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
    	// create model attribute to bind form data
    	Customer theCustomer = new Customer();
    	// attribute name, value 순
    	theModel.addAttribute("customer",theCustomer);    	
    	return "customer-form";
    }
    
    // form의 action과 일치해야함.
    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
    
    	// save the customer using our service
    	customerService.saveCustomer(theCustomer);
    	return "redirect:/customer/list";
    }
    
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
    	
    	// get the customer from the database
    	Customer theCustomer = customerService.getCustomers(theId);
    	
    	// set customer as a model attribute to pre-populate the form
    	theModel.addAttribute("customer", theCustomer);
    	// send over to our form
    	return "customer-form";
    }
}
