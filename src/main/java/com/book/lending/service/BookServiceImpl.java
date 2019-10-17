package com.book.lending.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.book.lending.dto.AddBookDto;
import com.book.lending.dto.AddBookResponseDto;
import com.book.lending.dto.BookDto;
import com.book.lending.dto.BookListDto;
import com.book.lending.entity.Book;
import com.book.lending.exception.BookLendingException;
import com.book.lending.repository.BookRepository;
import com.book.lending.util.BookUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Override
	public BookListDto getBookList() {

		log.info("get book list method in book service");

		List<BookDto> bookDtoList = new ArrayList<>();
		List<Book> book = bookRepository.findAll();

		book.stream().forEach(b -> {
			BookDto bookDto = new BookDto();
			BeanUtils.copyProperties(b, bookDto);
			bookDtoList.add(bookDto);
		});

		BookListDto bookList = new BookListDto();
		bookList.setBookDto(bookDtoList);
		bookList.setMessage(BookUtil.getBooks);
		bookList.setStatusCode(HttpStatus.OK.value());
		return bookList;
	}

	@Override
	public AddBookResponseDto addBook(AddBookDto addBookDto) {

		log.info("add book to book list in book service");
		
		int bookNum = (int) (Math.random() * 9000) + 1000;
		
		Book book = new Book();
		book.setStatus(BookUtil.status);
		book.setBookNum(bookNum);
		book.setAuthor(addBookDto.getAuthor());
		book.setBookName(addBookDto.getBookName());
		book.setCopyRight(addBookDto.getCopyRight());
		book.setEdition(addBookDto.getEdition());
		book.setLanguage(addBookDto.getLanguage());
		if (addBookDto.getCategoryType().equals(BookUtil.CATEGORY_TYPE)) 
			book.setCategoryId(1);
		else 
			book.setCategoryId(2);
		
		
		Book book1 = bookRepository.save(book);
		AddBookResponseDto addBookResponseDto = new AddBookResponseDto();
		
		if (Objects.isNull(book1)) 
			throw new BookLendingException(BookUtil.ADD_BOOK_FAILURE);
		else 
			addBookResponseDto.setMessage(BookUtil.addBook);
		
		addBookResponseDto.setStatusCode(HttpStatus.OK.value());
		return addBookResponseDto;

	}

}
