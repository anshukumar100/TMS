package org.anshu.service.exception;

public class TransactionServiceException extends Exception{

	private static final long serialVersionUID = 701688450575548978L;

	public TransactionServiceException() {
		super();
	}
	
	public TransactionServiceException(final String messages) {
		super(messages);
	}
	
	public TransactionServiceException(final Error errors) {
		super(errors);
	}
	
}
