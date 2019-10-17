package com.book.lending.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.book.lending.dto.RequestBook;
import com.book.lending.dto.ResponseDto;
import com.book.lending.service.RequestBookServiceImpl;
import com.book.lending.util.BookUtil;

@RunWith(MockitoJUnitRunner.class)
public class RequestBookControllerTest {

	@Mock
	RequestBookServiceImpl requestBookServiceImpl;

	@InjectMocks
	RequestBookController requestBookController;

	@Test
	public void testRequestBook() {

		RequestBook requestBook = new RequestBook();
		requestBook.setBookId(1);
		requestBook.setUserId(1);
		ResponseDto responseDTO = new ResponseDto();
		responseDTO.setStatusCode(BookUtil.BOOK_REQUEST_SUCCESS_CODE);

		Mockito.when(requestBookServiceImpl.requestingBook(requestBook)).thenReturn(responseDTO);

		ResponseEntity<ResponseDto> actualValue = requestBookController.requestBook(requestBook);

		assertEquals(responseDTO.getStatusCode(), actualValue.getBody().getStatusCode());

	}

}
