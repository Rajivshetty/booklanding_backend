package com.book.lending.exception;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ErrorResponse {

	public ErrorResponse(LocalDate now, String message2, String description) {
	}
	private LocalDate timestamp;
	private String message;
	private int statusCode;


}
