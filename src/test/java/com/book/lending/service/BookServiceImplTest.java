package com.book.lending.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.book.lending.dto.AddBookDto;
import com.book.lending.dto.AddBookResponseDto;
import com.book.lending.dto.BookDto;
import com.book.lending.dto.BookListDto;
import com.book.lending.entity.Book;
import com.book.lending.repository.BookRepository;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {

	@Mock
	BookRepository bookRepo;

	@InjectMocks
	BookServiceImpl bookService;

	BookDto bookDto1 = null;
	BookDto bookDto2 = null;
	List<BookDto> list = null;

	@Before
	public void setup() {
		bookDto1 = new BookDto();
		bookDto1.setAuthor("Shakes");
		bookDto2 = new BookDto();
		bookDto2.setAuthor("Madhu");
		list = new ArrayList<>();
		list.add(bookDto1);
		list.add(bookDto2);
	}

	@Test
	public void testGetBookList() {

		BookListDto bookListDto = new BookListDto();
		bookListDto.setBookDto(list);
		Book book1 = new Book();
		Book book2 = new Book();
		List<Book> bookList = new ArrayList<>();
		bookList.add(book1);
		bookList.add(book2);
		Mockito.when(bookRepo.findAllByOrderByBookName()).thenReturn(bookList);
		BookListDto bookListDto1 = bookService.getBookList();
		assertEquals(bookList.size(), bookListDto1.getBookDto().size());
	}

	@Test
	public void testAddBook() {

		AddBookDto addBookDto = new AddBookDto();
		addBookDto.setAuthor("Shakes");
		addBookDto.setCategoryType("Fiction");
		AddBookResponseDto addBookResponseDto = new AddBookResponseDto();
		addBookResponseDto.setMessage("ADDED SUCCESSFULLY");
		Book book = new Book();
		book.setAuthor("Shakes");
		book.setCategoryId(1);
		Mockito.when(bookRepo.save(Mockito.any())).thenReturn(book);
		AddBookResponseDto obj = bookService.addBook(addBookDto);
		assertEquals(addBookResponseDto.getMessage(), obj.getMessage());
	}

}
