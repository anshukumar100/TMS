package org.anshu.dao;

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
