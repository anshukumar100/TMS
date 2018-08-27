package org.anshu.service.exception;

/**
 * This class represents the exception class which needs to be thrown from  TransactionService implementation
 * 
 * @author Anshu Kumar
 *
 */
public class TransactionServiceException extends Exception{

	private static final long serialVersionUID = 701688450575548978L;

	/**
	 * default constructor
	 */
	public TransactionServiceException() {
		super();
	}
	
	/**
	 * parametrized constructor with string error as input
	 * @param messages the error message
	 */
	public TransactionServiceException(final String messages) {
		super(messages);
	}
	

	/**
	 * parametrized constructor with ErrorDetails as input
	 * @param errors the details of error messageerror message
	 */
	public TransactionServiceException(final ErrorDetails errors) {
		super(errors);
	}
	
}
