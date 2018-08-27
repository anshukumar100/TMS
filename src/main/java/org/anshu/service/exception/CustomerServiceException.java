package org.anshu.service.exception;

/**
 * This class represents the exception class which needs to be thrown from  CustomerService implementation
 * 
 * @author Anshu Kumar
 *
 */
public class CustomerServiceException extends Exception{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 701688450575548978L;

	/**
	 * default constructor
	 */
	public CustomerServiceException() {
		super();
	}
	
	/**
	 * parametrized constructor with string error as input
	 * @param messages the error message
	 */
	public CustomerServiceException(final String messages) {
		super(messages);
	}
	

	/**
	 * parametrized constructor with ErrorDetails as input
	 * @param errors the details of error messageerror message
	 */
	public CustomerServiceException(final ErrorDetails errors) {
		super(errors);
	}
	
}
