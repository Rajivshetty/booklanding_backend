/**
 * 
 */
package com.book.lending.service;

import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.lending.dto.BorrowBookResponseDto;
import com.book.lending.entity.Book;
import com.book.lending.entity.BookLending;
import com.book.lending.entity.User;
import com.book.lending.exception.BookLendingException;
import com.book.lending.repository.BookLendingRepository;
import com.book.lending.repository.BookRepository;
import com.book.lending.repository.UserRepository;
import com.book.lending.util.BookUtil;

/**
 * @author User1
 *
 */

@Service
public class BorrowBookServiceImpl implements BorrowBookService {

	 public static final Logger log =LoggerFactory.getLogger(BorrowBookServiceImpl.class);

	@Autowired
	private BookLendingRepository bookLendingRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.book.lending.service.BorrowBookService#issueBookService(java.lang.
	 * Integer, java.lang.Integer)
	 */
	@Override
	public BorrowBookResponseDto issueBookService(Integer bookId, Integer userId) {

		LocalDate today = LocalDate.now();
		LocalDate nextWeek = today.plusDays(7);

		Optional<Book> book = bookRepository.findById(bookId);

		Optional<User> user = userRepository.findById(userId);
		Book getBook = null;
		User getUser = null;

		BorrowBookResponseDto borrowBookResponseDto = new BorrowBookResponseDto();
		if (user.isPresent() && book.isPresent()) {
			getBook=book.get();
			getUser = user.get();

			BookLending bookLending = new BookLending();
			bookLending.setBookId(getBook.getBookId());
			bookLending.setUserId(getUser.getUserId());
			bookLending.setIssuedDate(today);
			bookLending.setSubmissionDate(nextWeek);
			
			Optional<Book>optBook=bookRepository.findById(bookId);
			if(optBook.isPresent()) {
				Book books=optBook.get();
				books.setStatus(BookUtil.BOOK_REQUEST_NOT_AVAILABLE);
			}
			
			
			bookLendingRepository.save(bookLending);

		} else {
			throw new BookLendingException(BookUtil.BORROW_EXCEPTION_MESSAGE);

		}

		borrowBookResponseDto.setStatusCode(BookUtil.BORROW_STATUS_CODE);
		borrowBookResponseDto.setMessage(BookUtil.BORROW_STATUS__MESSAGE);
		borrowBookResponseDto.setBookName(getBook.getBookName());
		borrowBookResponseDto.setAuthor(getBook.getAuthor());
		borrowBookResponseDto.setLanguage(getBook.getLanguage());
		return borrowBookResponseDto;
	}

}
