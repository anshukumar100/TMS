package org.anshu.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.anshu.commons.StringUtils;
import org.anshu.dao.AccountDao;
import org.anshu.dao.TransactionDao;
import org.anshu.entity.Account;
import org.anshu.entity.Transaction;
import org.anshu.service.TransactionService;
import org.anshu.service.exception.ErrorDetails;
import org.anshu.service.exception.ResourceNotFoundException;
import org.anshu.service.exception.TransactionServiceException;
import org.anshu.service.validator.TransactionValidator;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * Implementation class of TransactionService which provides all the business layer implementation
 * 
 * @author Anshu Kumar
 * @see org.anshu.service.TransactionService
 *
 */

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionValidator transactionValidator;
	
	@Autowired
	private TransactionDao transactionDao;
	
	@Autowired
	private AccountDao accountDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = TransactionServiceException.class)
	public void createTransaction(Transaction transaction) throws TransactionServiceException, ResourceNotFoundException{

		Account senderAccount = transactionValidator.validateAccount(transaction.getSenderAccount().getAccountNumber());
		Account receiverAccount = transactionValidator.validateAccount(transaction.getReceiverAccount().getAccountNumber());

		if(senderAccount == null) {
			ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed","Sender Account does not exist");
			throw new ResourceNotFoundException(errorDetails.getDetails());
		}

		if(receiverAccount == null) {
			ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed","Receiver Account does not exist");
			throw new ResourceNotFoundException(errorDetails.getDetails());
		}

		//validate the transfer amount 
		boolean isValidTransferAmount = transactionValidator.validateTransferAount(senderAccount.getBalance(),transaction.getAmount());
		if(isValidTransferAmount) {			
			//determine the new balance for sender
			BigDecimal newSenderBalance = senderAccount.getBalance().subtract(transaction.getAmount());
			senderAccount.setBalance(newSenderBalance);
			
			//determine the new balance for receiver
			BigDecimal newReceiverBalance = receiverAccount.getBalance().add(transaction.getAmount());
			receiverAccount.setBalance(newReceiverBalance);

			//create sender and receiver
			createTransaction(transaction,"DEBIT",senderAccount,receiverAccount);
			createTransaction(transaction,"CREDIT",receiverAccount,senderAccount);

			//update account to reflect new account balances
			accountDao.save(senderAccount);
			accountDao.save(receiverAccount);

		}else {
			//throw validation that overdrawing of account is not allowed
			ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed","Account balance is insufficient to complete the transaction");
			throw new TransactionServiceException(errorDetails);
		}
	}

	public void createTransaction(Transaction transaction, String transferType, Account sender, Account Receiver) {
		Transaction transactionObj = new Transaction();
		transactionObj.setAmount(transaction.getAmount());
		transactionObj.setSenderAccount(sender);
		transactionObj.setReceiverAccount(Receiver);
		transactionObj.setTransactionTime(new Date());
		transactionObj.setTransactionDescription(transaction.getTransactionDescription());
		transactionObj.setTransactionType(transferType);
		transactionDao.save(transactionObj);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = TransactionServiceException.class)
	public List<Transaction> getTransaction(String accountNumber) throws TransactionServiceException, ResourceNotFoundException {
		try {
			Account account = transactionValidator.validateAccount(accountNumber);
			if((!StringUtils.isValidString(accountNumber)) ||  account == null) {
				ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed","Account does not exist");
				throw new ResourceNotFoundException(errorDetails.getDetails());
			}
			
			return transactionDao.findBySenderAccountAccountId(account.getAccountId());
		}catch(HibernateException e) {
			ErrorDetails errorDetails = new ErrorDetails(new Date(), "Error while fetching transaction details of an account","Error while transaction details of an account");
			throw new TransactionServiceException(errorDetails);
		}
	}
}


