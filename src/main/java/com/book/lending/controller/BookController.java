package com.book.lending.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.lending.dto.AddBookDto;
import com.book.lending.dto.AddBookResponseDto;
import com.book.lending.dto.BookListDto;
import com.book.lending.service.BookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "*", "*/" }, allowedHeaders = { "*", "*/" })
@Slf4j

/**
 * 
 * @author mahesh
 *
 */
public class BookController {

	@Autowired
	BookService bookService;
	
	/**
	 * 
	 * @return list of all books with status code
	 */
	
	@GetMapping("/books")
	public ResponseEntity<BookListDto> getBookList() {

		log.info("get book list method in book controller");
		return new ResponseEntity<>(bookService.getBookList(), HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param addBookDto gives book details for adding into books list
	 * @return AddBookResponseDto contains message and status code
	 */
	
	@PostMapping("/books")
	public ResponseEntity<AddBookResponseDto> addBook(@RequestBody AddBookDto addBookDto) {

		log.info("add book to list in book controller");
		return new ResponseEntity<>(bookService.addBook(addBookDto), HttpStatus.OK);
	}
}
