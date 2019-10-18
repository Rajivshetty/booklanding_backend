package com.book.lending.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.book.lending.dto.AddBookDto;
import com.book.lending.dto.AddBookResponseDto;
import com.book.lending.dto.BookDto;
import com.book.lending.dto.BookListDto;
import com.book.lending.entity.Book;
import com.book.lending.repository.BookRepository;
import com.book.lending.util.BookUtil;


/**
 * @author Mahesh
 *
 */
@Service
public class BookServiceImpl implements BookService {

	public static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	BookRepository bookRepository;
	
	/**
	 * @return BookListDto
	 * 
	 * This method returns the Books List in Sorting order
	 */

	@Override
	public BookListDto getBookList() {

		log.debug("get book list method in book service");

		List<BookDto> bookDtoList = new ArrayList<>();
		List<Book> book = bookRepository.findAllByOrderByBookName();

		book.stream().forEach(b -> {
			BookDto bookDto = new BookDto();
			BeanUtils.copyProperties(b, bookDto);
			bookDtoList.add(bookDto);
		});

		BookListDto bookList = new BookListDto();
		bookList.setBookDto(bookDtoList);
		bookList.setMessage(BookUtil.GETBOOKS);
		bookList.setStatusCode(HttpStatus.OK.value());
		return bookList;
	}

	/**
	 * @return AddBookResponseDto
	 * 
	 * This method contains the logic to add book
	 */
	@Override
	public AddBookResponseDto addBook(AddBookDto addBookDto) {

		log.info("add book to book list in book service");

		int bookNum = (int) (Math.random() * 9000) + 1000;

		Book book = new Book();
		book.setStatus(BookUtil.STATUS);
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

		bookRepository.save(book);
		AddBookResponseDto addBookResponseDto = new AddBookResponseDto();

		addBookResponseDto.setMessage(BookUtil.ADDBOOK);

		addBookResponseDto.setStatusCode(HttpStatus.OK.value());
		return addBookResponseDto;

	}

}
