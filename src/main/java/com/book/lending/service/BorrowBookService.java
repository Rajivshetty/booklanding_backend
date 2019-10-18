/**
 * 
 */
package com.book.lending.service;

import com.book.lending.dto.BorrowBookResponseDto;
import com.book.lending.exception.BookLendingException;

/**
 * @author User1
 *
 */

public interface BorrowBookService {
	/*
	 * 
	 */
	BorrowBookResponseDto issueBookService(Integer bookId, Integer userId) throws BookLendingException;

}
