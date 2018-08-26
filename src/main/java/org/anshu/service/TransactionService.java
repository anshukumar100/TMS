/**
 * 
 */
package org.anshu.service;

import java.util.List;

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

	/**
	 * This method id used find all the transactions of a given customer ID
	 * @param accountNumber input account number whose transactions needs to be fetched 
	 * @return list of transactions performed by the account if exist or else null
	 * @throws TransactionServiceException dao layer exception
	 * @throws ResourceNotFoundException no data found exception
	 */
	public List<Transaction> getTransaction(String accountNumber)throws TransactionServiceException,ResourceNotFoundException;

}
