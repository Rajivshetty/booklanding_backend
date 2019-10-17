package com.book.lending.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.book.lending.dto.RequestBook;
import com.book.lending.dto.ResponseDto;
import com.book.lending.entity.Book;
import com.book.lending.entity.BookRequest;
import com.book.lending.exception.BookLendingException;
import com.book.lending.repository.BookRepository;
import com.book.lending.repository.BookRequestRepository;
import com.book.lending.util.BookUtil;

@RunWith(MockitoJUnitRunner.class)
public class RequestBookServiceImplTest {

	@Mock
	BookRequestRepository bookRequestRepository;

	@Mock
	BookRepository bookRepository;

	@InjectMocks
	RequestBookServiceImpl RequestBookServiceImpl;

	BookRequest bookRequest = null;
	Book book = null;
	RequestBook requestBook = null;

	@Before
	public void setup() {
		bookRequest = new BookRequest();

		bookRequest.setBookId(1);
		bookRequest.setUserId(1);
		bookRequest.setRequestDate(LocalDate.now());

		book = new Book();
		book.setBookId(1);
		book.setStatus("NOT AVAILABLE");
		requestBook = new RequestBook();
		requestBook.setBookId(1);
		requestBook.setUserId(1);

	}

	@Test
	public void testRequestingBook() {

		ResponseDto responseDTO = new ResponseDto();
		responseDTO.setStatusCode(BookUtil.BOOK_REQUEST_SUCCESS_CODE);

		Mockito.when(bookRepository.findByBookIdAndStatus(Mockito.anyInt(), Mockito.any()))
				.thenReturn(Optional.of(book));
		Mockito.when(bookRequestRepository.save(Mockito.any())).thenReturn(bookRequest);

		ResponseDto actualValue = RequestBookServiceImpl.requestingBook(requestBook);
		assertEquals(responseDTO.getStatusCode(), actualValue.getStatusCode());

	}

	@Test(expected = BookLendingException.class)
	public void testRequestingBookRequest1() {
		BookRequest bookRequest = new BookRequest();

		bookRequest.setBookId(22);
		bookRequest.setUserId(22);
		ResponseDto responseDTO = new ResponseDto();
		responseDTO.setStatusCode(BookUtil.BOOK_REQUEST_SUCCESS_CODE);

		RequestBookServiceImpl.requestingBook(requestBook);

	}

}
