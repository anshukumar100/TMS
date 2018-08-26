/**
 * 
 */
package org.anshu.service;

import java.util.List;

import org.anshu.entity.Customer;
import org.anshu.service.exception.CustomerServiceException;
import org.anshu.service.exception.ResourceNotFoundException;

/**
 * 
 * Interface to have blue print of all the business methods related to customer operation
 * @author Anshu Kumar
 * @version : 1.0.0
 *
 */
public interface CustomerService extends TMSService{
	
	/**
	 * This method is used to find out a given customer
	 * @param customerId : the customer ID whose information needs to be fetched
	 * @return the customer with matching customer id if found or else NULL
	 * @throws ResourceNotFoundException resource not found error
	 * @throws CustomerServiceException generic Customer Service error
	 */
	public Customer getCustomer(Long customerId) throws ResourceNotFoundException, CustomerServiceException;
	
	/**
	 * This method is used to create a new customer in the database by passing the details of the customer
	 * @param customer : input customer details
	 * @return the newly created customer object 
	 * @throws CustomerServiceException wrapper exception for database errors
	 */
	public Customer createCustomer(Customer customer) throws CustomerServiceException;

	/**
	 * This method is used to get all the customers in the application
	 * @return list of customers in the system if exists or NULL
	 * @throws CustomerServiceException  wrapper exception for database errors
	 */
	public List<Customer> findAllCustomer()throws CustomerServiceException;;
	

}
