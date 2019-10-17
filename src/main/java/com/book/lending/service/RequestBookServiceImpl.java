
package com.book.lending.service;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.lending.dto.RequestBook;
import com.book.lending.dto.ResponseDto;
import com.book.lending.entity.Book;
import com.book.lending.entity.BookRequest;
import com.book.lending.exception.BookLendingException;
import com.book.lending.repository.BookRepository;
import com.book.lending.repository.BookRequestRepository;
import com.book.lending.util.BookUtil;

/**
 * @author Shiva
 *
 */
@Service
public class RequestBookServiceImpl implements RequestBookService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestBookServiceImpl.class);

	@Autowired
	BookRequestRepository bookRequestRepository;
	@Autowired
	BookRepository bookRepository;
 
	@Override
	public ResponseDto requestingBook(RequestBook requestBook) {

		ResponseDto responseDTO = new ResponseDto();
		BookRequest bookRequest = new BookRequest();

		bookRequest.setBookId(requestBook.getBookId());
		bookRequest.setUserId(requestBook.getUserId());
		bookRequest.setRequestDate(LocalDate.now());

		LOGGER.info("Inside Request Book Service Impl BookId");

		Optional<Book> optBook = bookRepository.findByBookIdAndStatus(requestBook.getBookId(),
				BookUtil.BOOK_REQUEST_NOT_AVAILABLE);

		if (optBook.isPresent()) {
			BookRequest bookRequestResponse = bookRequestRepository.save(bookRequest);
			if (Objects.isNull(bookRequestResponse)) {
				throw new BookLendingException(BookUtil.BOOK_REQUEST_EXCEPTION);
			} else {
				responseDTO.setMessage(BookUtil.BOOK_REQUEST_SUCCESS);
				responseDTO.setStatusCode(BookUtil.BOOK_REQUEST_SUCCESS_CODE);
			}
		}

		else {
			throw new BookLendingException(BookUtil.NO_BOOK_FOUND);
		}

		return responseDTO;
	}

}
