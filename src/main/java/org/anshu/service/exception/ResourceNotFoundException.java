package org.anshu.service.exception;

/**
 * This class represents the resource not found exception
 * 
 * @author Anshu Kumar
 *
 */
public class ResourceNotFoundException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3147373530789701970L;

	/**
	 * default constructor
	 */
	public ResourceNotFoundException() {
		super();
	}
	
	/**
	 * parametrized constructor with string error as input
	 * @param messages the error message
	 */
	public ResourceNotFoundException(final String messages) {
		super(messages);
	}
	

	/**
	 * parametrized constructor with ErrorDetails as input
	 * @param errors the details of error messageerror message
	 */
	public ResourceNotFoundException(final ErrorDetails errors) {
		super(errors);
	}
}
