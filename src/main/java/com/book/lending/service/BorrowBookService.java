/**
 * 
 */
package com.book.lending.service;

import com.book.lending.dto.BorrowBookResponseDto;

/**
 * @author User1
 *
 */

public interface BorrowBookService {
	/*
	 * 
	 */
	BorrowBookResponseDto issueBookService(Integer bookId, Integer userId);

}
