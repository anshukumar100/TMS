package org.anshu.service.exception;

public class CustomerServiceException extends Exception{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 701688450575548978L;

	public CustomerServiceException() {
		super();
	}
	
	public CustomerServiceException(final String messages) {
		super(messages);
	}
	
	public CustomerServiceException(final ErrorDetails errors) {
		super(errors);
	}
	
}
