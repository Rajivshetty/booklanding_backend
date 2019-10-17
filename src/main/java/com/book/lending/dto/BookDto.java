package com.book.lending.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
	
	private String bookName;
	private Integer bookNum;
	private String author;
	private String language;
	private Integer edition;
	private String status;
}
