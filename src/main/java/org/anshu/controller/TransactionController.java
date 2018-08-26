/**
 * 
 */
package org.anshu.controller;

import java.util.List;

import javax.validation.Valid;

import org.anshu.entity.Transaction;
import org.anshu.service.TransactionService;
import org.anshu.service.exception.ResourceNotFoundException;
import org.anshu.service.exception.TransactionServiceException;
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
 * Rest controller for handling all the operations related to Transaction between two accounts
 * @author Anshu Kumar
 * 
 * @author Anshu Kumar
 * @version : 1.0.0
 * 
 *	REST URLS: 
 *
 *	1. GET : /transactions/{customerId} -> to retrieve transaction of a given customer ID
 *  2. POST : /transactions -> to crate a customer IDtransfer between two customers
 *	3. GET : /transactions -> to retrieve all the transactions
 */

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;

	/**
	 * This Rest controller is used to do transaction between two accounts
	 * @param transaction details of the transaction
	 * @throws ResourceNotFoundException account not found exception
	 */
	@RequestMapping(value = "transactions", 
			method = RequestMethod.POST, 
			headers = "Accept=application/json", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public void createTransaction(@Valid @RequestBody Transaction transaction) throws ResourceNotFoundException{
		try {
			transactionService.createTransaction(transaction);
		} catch (TransactionServiceException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This Rest controller is used to get transactions of a give account
	 * @param transaction details of the transaction
	 * @throws ResourceNotFoundException account not found exception
	 */
	@RequestMapping(value = "transactions/{accountnumber}", 
			method = RequestMethod.GET, 
			headers = "Accept=application/json", 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public List<Transaction> getTransaction(@PathVariable String accountnumber) throws ResourceNotFoundException{
		List<Transaction> transactions = null;
		try {
			transactions = transactionService.getTransaction(accountnumber);
		} catch (TransactionServiceException e) {
			e.printStackTrace();
		}
		return transactions;
	}
	
}
