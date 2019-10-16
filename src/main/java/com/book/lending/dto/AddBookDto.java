package com.book.lending.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddBookDto {

	private String bookName;
	private String author;
	private String language;
	private Integer copyRight;
	private Integer edition;
	private String categoryType;

}
