/**
 * 
 */
package org.anshu.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.anshu.dao.CustomerDao;
import org.anshu.entity.Customer;
import org.anshu.service.CustomerService;
import org.anshu.service.exception.CustomerServiceException;
import org.anshu.service.exception.ErrorDetails;
import org.anshu.service.exception.ResourceNotFoundException;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation class of CustomerService which provides all the business layer implementation
 * 
 * @author Anshu Kumar
 * @see org.anshu.service.CustomerService
 *
 */

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = CustomerServiceException.class)
	public Customer getCustomer(Long customerId) throws ResourceNotFoundException,CustomerServiceException {
		Customer customer = null;
		try {
			Optional<Customer> customers = customerDao.findById(customerId);
			if(customers.get() == null) {
				ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed. Customer does not exist","Validation Failed. Customer does not exist");
				throw new ResourceNotFoundException(errorDetails);
			}
			customer = customers.get();
		}catch(HibernateException e) {
			ErrorDetails errorDetails = new ErrorDetails(new Date(), "Error while fecthing customer details","Error while fecthing customer details");
			throw new CustomerServiceException(errorDetails);
		}

		return customer;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = CustomerServiceException.class)
	public Customer createCustomer(Customer customer) throws CustomerServiceException{
		try {
			return customerDao.save(customer);
		}catch(HibernateException e) {
			ErrorDetails errorDetails = new ErrorDetails(new Date(), "Error while saving customer details","Error while saving customer details");
			throw new CustomerServiceException(errorDetails);
		}
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = CustomerServiceException.class)
	public List<Customer> findAllCustomer() throws CustomerServiceException {
		try {
			return (List<Customer>) customerDao.findAll();
		}catch(HibernateException e) {
			ErrorDetails errorDetails = new ErrorDetails(new Date(), "Error while fetching all the customer details","Error while fetching all the customer details");
			throw new CustomerServiceException(errorDetails);
		}
	}
}
