package com.book.lending.exception;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter

public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String message;
	private Integer statusCode;
	private LocalDate tiemStamp;

	/**
	 * @param localDate
	 * @param string
	 * @param i
	 */
	public ErrorResponse(LocalDate localDate, String string, int i) {
		super();
		this.message = string;
		this.statusCode = i;
		this.tiemStamp = localDate;
	}

	/**
	 * @param message
	 * @param statusCode
	 */

	/**
	 * 
	 */
	public ErrorResponse() {
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
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
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

}
