/**
 * 
 */
package com.book.lending.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.book.lending.dto.BorrowBookRequestDto;
import com.book.lending.dto.BorrowBookResponseDto;
import com.book.lending.entity.Book;
import com.book.lending.entity.User;
import com.book.lending.exception.BookLendingException;
import com.book.lending.service.BorrowBookService;
import com.book.lending.util.BookUtil;

/**
 * @author User1
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class BorrowBookControllerTest {
	 
	@Mock
	private BorrowBookService borrowBookService;
	
	@InjectMocks
	private BorrowBookController borrowBookController;

	/**
	 * Test method for {@link com.book.lending.controller.BorrowBookController#issueBook(com.book.lending.dto.BorrowBookRequestDto)}.
	 * @throws BookLendingException 
	 */
	@Test
	public void testIssueBook() throws BookLendingException {

		User user = new User();
		Book book = new Book();
		user.setUserId(1);
		book.setBookId(2); 
		
		BorrowBookRequestDto borrowBookRequestDto=new BorrowBookRequestDto();
		borrowBookRequestDto.setBookId(2);
		borrowBookRequestDto.setUserId(1);
		
		
		BorrowBookResponseDto borrowBookResponseDto = new BorrowBookResponseDto();
		borrowBookResponseDto.setStatusCode(BookUtil.BORROW_STATUS_CODE);
		borrowBookResponseDto.setMessage(BookUtil.BORROW_STATUS_MESSAGE);
		borrowBookResponseDto.setBookName("Restfull");
		borrowBookResponseDto.setAuthor("Bill Burke");
		borrowBookResponseDto.setLanguage("English");
	
		Mockito.when(borrowBookService.issueBookService(book.getBookId(), user.getUserId())).thenReturn(borrowBookResponseDto);
		
		ResponseEntity<BorrowBookResponseDto> bookResponseDto=borrowBookController.issueBook(borrowBookRequestDto);
		
		assertEquals(borrowBookResponseDto.getStatusCode(),bookResponseDto.getBody().getStatusCode());
	}

}
