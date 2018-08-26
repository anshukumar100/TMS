/**
 * 
 */
package org.anshu.controller;

import java.util.List;

import javax.validation.Valid;

import org.anshu.entity.Customer;
import org.anshu.service.CustomerService;
import org.anshu.service.exception.CustomerServiceException;
import org.anshu.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for handling all the operations related to customer
 * it can be used to create and fetch the customer details
 * 
 * @author Anshu Kumar
 * @version : 1.0.0
 * 
 *	REST URLS: 
 *
 *	1. GET : /customers/{customerId} -> to retrieve information of a given customer ID
 *  2. POST : /customers -> to crate a customer ID
 *	3. GET : /customers -> to retrieve information of all the customers
 *
 */

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	/**
	 * This method is use to get the customer details by providing the customer ID
	 * @param customerId the customer ID whose details need to be fetched
	 * @return the customer details if found else will return Resource not found exception
	 */
	@RequestMapping(value = "customers/{customerId}", 
			method = RequestMethod.GET, 
			headers = "Accept=application/json", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public Customer findCustomer(@PathVariable String customerId) throws ResourceNotFoundException{
		Customer customer = null;
		try {
			customer = customerService.getCustomer(Long.valueOf(customerId));
			if(customer == null) {
				throw new ResourceNotFoundException();
			}
		} catch (NumberFormatException | ResourceNotFoundException | CustomerServiceException e) {
			e.printStackTrace();
		}
		
		return customer;
	}
	
	
	/**
	 * This method is used to create a new customer
	 * @param customer input details of customer
	 * @return the newly created customer Details
	 */
	@RequestMapping(value = "customers", 
			method = RequestMethod.POST, 
			headers = "Accept=application/json", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public Customer createCustomer(@Valid @RequestBody Customer customer){
		Customer customerObj = null;
		try {
			customerObj = customerService.createCustomer(customer);
		} catch (CustomerServiceException e) {
			e.printStackTrace();
		}
		return customerObj;
	}
	
	/**
	 * This Rest controller is used to fetch all the customers in the application
	 * @return list of customers if exist or No data found exception
	 * @throws ResourceNotFoundException data not found
	 */
	@RequestMapping(value = "customers", 
			method = RequestMethod.GET, 
			headers = "Accept=application/json", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public List<Customer> findAllCustomer() throws ResourceNotFoundException{
		List<Customer> customers = null;
		try {
			customers = customerService.findAllCustomer();
			if(customers == null || customers.isEmpty()) {
				throw new ResourceNotFoundException();
			}
		} catch (CustomerServiceException e) {
			e.printStackTrace();
		}
		return customers;
	}
	
}
