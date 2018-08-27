package org.anshu.dao;

/**
 * 
 * This is wrapper exception class to throw all the dao layer exceptions 
 * 
 * @author Anshu Kumar
 *
 */
public class TMSDaoException extends Exception{
	

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8091510671214920462L;
	/**
	 * Associaction to the messages component that will handle error, warning and info messages.
	 */
	private String message;
	/**
	 * msg
	 * @param msg msg
	 */
	public TMSDaoException(String msg) {
		super(msg);
	}
	/**
	 * Default constructor
	 */
	public TMSDaoException() {
		super();
	}

	/**
	 * @return messages messages
	 */
	public String getMessages() {
		return message;
	}
	/**
	 * @param messages the messages to set
	 */
	public void setMessages(String message) {
		this.message = message;
	}


}
