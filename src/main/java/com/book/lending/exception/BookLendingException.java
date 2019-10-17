package com.book.lending.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class BookLendingException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;	
	private final String message;

	
	
	public BookLendingException(String message){
		super(message);
		
	}
	
	

}
