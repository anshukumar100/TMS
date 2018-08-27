/**
 * 
 */
package org.anshu.service;

import org.anshu.entity.Transaction;
import org.anshu.service.exception.ResourceNotFoundException;
import org.anshu.service.exception.TransactionServiceException;

/**
 * 
 * Interface to have blue print of all the business methods related to traction operation
 * @author Anshu Kumar
 * @version : 1.0.0
 *
 */
public interface TransactionService {

	/**
	 * This method is used to do transaction between two accounts
	 * @param transaction details of the transaction
	 * @throws TransactionServiceException dao layer exception wrapper
	 * @throws ResourceNotFoundException resource not found exception
	 */
	public void createTransaction(Transaction transaction) throws TransactionServiceException,ResourceNotFoundException;
	

}
