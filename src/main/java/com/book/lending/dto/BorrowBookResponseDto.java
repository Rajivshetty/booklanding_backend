/**
 * 
 */
package com.book.lending.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author User1
 *
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowBookResponseDto {

	private Integer statusCode;
	private String message;
	private String bookName;
	private String author;
	private String language;
}
