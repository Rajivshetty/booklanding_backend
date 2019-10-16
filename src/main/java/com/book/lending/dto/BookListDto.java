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
}
