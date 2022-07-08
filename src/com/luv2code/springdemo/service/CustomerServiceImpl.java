package com.luv2code.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		// Delegate calls to DAO
		
		return customerDAO.getCustomers();
	}


	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
		
	}


	@Override
	@Transactional
	public Customer getCustomers(int theId) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers(theId);
	}


	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);
	}

}
