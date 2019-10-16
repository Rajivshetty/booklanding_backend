package com.book.lending.exception;

import java.io.Serializable;

public class ErrorResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private Integer statusCode;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the statusCode
	 */
	public Integer getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode
	 *            the statusCode to set
	 */
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

}
