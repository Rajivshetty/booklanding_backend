/**
 * 
 */
package com.book.lending.service.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.book.lending.dto.BorrowBookResponseDto;
import com.book.lending.entity.Book;
import com.book.lending.entity.BookLending;
import com.book.lending.entity.User;
import com.book.lending.exception.BookLendingException;
import com.book.lending.repository.BookLendingRepository;
import com.book.lending.repository.BookRepository;
import com.book.lending.repository.UserRepository;
import com.book.lending.service.BorrowBookServiceImpl;
import com.book.lending.util.BookUtil;

/**
 * @author User1
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class BorrowBookServiceImplTest {

	
	@Mock
	private BookLendingRepository bookLendingRepository;

	@Mock
	private BookRepository bookRepository;

	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private BorrowBookServiceImpl borrowBookServiceImpl;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void issueBookServiceTest() {

		User user = new User();
		Book book = new Book();
		user.setUserId(1);
		book.setBookId(2);

		LocalDate today = LocalDate.now();
		LocalDate nextWeek = today.plusDays(7);
		BookLending bookLending = new BookLending();
		bookLending.setBookId(100);
		bookLending.setUserId(99);
		bookLending.setIssuedDate(today);
		bookLending.setSubmissionDate(nextWeek);

		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(user));
		Mockito.when(bookRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(book));

		Mockito.when(bookLendingRepository.save(bookLending)).thenReturn(null);

		BorrowBookResponseDto borrowBookResponseDto = new BorrowBookResponseDto();
		borrowBookResponseDto.setStatusCode(BookUtil.BORROW_STATUS_CODE);
		borrowBookResponseDto.setMessage(BookUtil.BORROW_STATUS_MESSAGE);
		borrowBookResponseDto.setBookName("Restfull");
		borrowBookResponseDto.setAuthor("Bill Burke");
		borrowBookResponseDto.setLanguage("English");

		BorrowBookResponseDto bookResponseDto = borrowBookServiceImpl.issueBookService(bookLending.getBookId(),
				bookLending.getUserId());

		assertEquals(borrowBookResponseDto.getStatusCode(), bookResponseDto.getStatusCode());

	}

	@Test(expected = BookLendingException.class)
	public void issueBookServiceTestException() {

		User user = new User();
		Book book = new Book();
		user.setUserId(1);
		book.setBookId(2);

		borrowBookServiceImpl.issueBookService(11, 12); 

	}

}
