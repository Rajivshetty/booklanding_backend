
package com.book.lending.service;

import static com.book.lending.util.BookUtil.BOOK_REQUEST_NOT_AVAILABLE;
import static com.book.lending.util.BookUtil.BOOK_REQUEST_SUCCESS;
import static com.book.lending.util.BookUtil.BOOK_REQUEST_SUCCESS_CODE;
import static com.book.lending.util.BookUtil.NO_BOOK_FOUND;

import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.lending.dto.ResponseDto;
import com.book.lending.entity.Book;
import com.book.lending.entity.BookRequest;
import com.book.lending.exception.BookLendingException;
import com.book.lending.repository.BookRepository;
import com.book.lending.repository.BookRequestRepository;

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

	/**
	 * @param RequestBook
	 * @return ResponseDto
	 * @throws BookLendingException This method takes the request for a particular
	 *                              book if it is not availale
	 */

	@Override
	public ResponseDto requestingBook(Integer bookId, Integer userId) throws BookLendingException {

		LOGGER.info("Inside Request Book Service Impl");
		ResponseDto responseDTO = new ResponseDto();
		BookRequest bookRequest = new BookRequest();

		bookRequest.setBookId(bookId);
		bookRequest.setUserId(userId);
		bookRequest.setRequestDate(LocalDate.now());

		LOGGER.info("BookId:{},UserId:{},RequestDate:{}", bookId, userId, LocalDate.now());

		Optional<Book> optBook = bookRepository.findByBookIdAndStatus(bookId, BOOK_REQUEST_NOT_AVAILABLE);

		if (optBook.isPresent()) {
			bookRequestRepository.save(bookRequest);
			responseDTO.setMessage(BOOK_REQUEST_SUCCESS);
			responseDTO.setStatusCode(BOOK_REQUEST_SUCCESS_CODE);
		} else {
			throw new BookLendingException(NO_BOOK_FOUND);
		}

		return responseDTO;
	}

}
