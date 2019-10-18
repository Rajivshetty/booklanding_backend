package com.book.lending.service;

import com.book.lending.dto.ResponseDto;
import com.book.lending.exception.BookLendingException;

public interface RequestBookService {

	public ResponseDto requestingBook(Integer bookId, Integer userId) throws BookLendingException;

}
