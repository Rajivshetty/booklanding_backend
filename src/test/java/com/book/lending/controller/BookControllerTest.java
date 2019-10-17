package com.book.lending.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;

import com.book.lending.dto.AddBookDto;
import com.book.lending.dto.AddBookResponseDto;
import com.book.lending.dto.BookDto;
import com.book.lending.dto.BookListDto;
import com.book.lending.entity.Book;
import com.book.lending.service.BookService;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

	@InjectMocks
	BookController bookController;

	@Mock
	BookService bookService;

	@Test
	public void testGetBookList() {
		BookDto bookDto1 = new BookDto();
		bookDto1.setAuthor("Shakes");
		BookDto bookDto2 = new BookDto();
		bookDto2.setAuthor("Madhu");
		List<BookDto> list = new ArrayList<>();
		list.add(bookDto1);
		list.add(bookDto2);
		BookListDto bookListDto = new BookListDto();
		bookListDto.setBookDto(list);
		Mockito.when(bookService.getBookList()).thenReturn(bookListDto);
		ResponseEntity<BookListDto> obj = bookController.getBookList();
		assertEquals(obj.getBody().getBookDto().size(), list.size());

	}

	@Test
	public void testAddBook() {

		AddBookDto addBookDto = new AddBookDto();
		addBookDto.setAuthor("Shakes");
		AddBookResponseDto addBookResponseDto = new AddBookResponseDto();
		addBookResponseDto.setMessage("ADDED SUCCESSFULLY");
		Book book = new Book();
		BeanUtils.copyProperties(addBookDto, book);
		Mockito.when(bookService.addBook(Mockito.any())).thenReturn(addBookResponseDto);
		ResponseEntity<AddBookResponseDto> obj = bookController.addBook(addBookDto);
		assertEquals(addBookResponseDto.getMessage(), obj.getBody().getMessage());
	}

}
