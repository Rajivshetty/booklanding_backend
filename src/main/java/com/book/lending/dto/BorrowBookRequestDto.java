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
public class BorrowBookRequestDto {

	private Integer bookId;
	private Integer userId;
}
