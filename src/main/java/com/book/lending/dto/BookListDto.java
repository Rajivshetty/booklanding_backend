package com.book.lending.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookListDto {
	
	private List<BookDto> bookDto;
	private Integer statusCode;
	private String message;
	/**
	 * @return the bookDto
	 */
	public List<BookDto> getBookDto() {
		return bookDto;
	}
	/**
	 * @param bookDto the bookDto to set
	 */
	public void setBookDto(List<BookDto> bookDto) {
		this.bookDto = bookDto;
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
	
	
}
