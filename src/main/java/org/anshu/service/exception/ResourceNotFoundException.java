package org.anshu.service.exception;

public class ResourceNotFoundException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3147373530789701970L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(final String message) {
		super(message);
	}
	
	public ResourceNotFoundException(final ErrorDetails errors) {
		super(errors);
	}
}
