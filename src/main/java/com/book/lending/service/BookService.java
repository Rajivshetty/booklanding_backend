package com.book.lending.service;

import org.springframework.stereotype.Service;

import com.book.lending.dto.AddBookDto;
import com.book.lending.dto.AddBookResponseDto;
import com.book.lending.dto.BookListDto;

@Service
public interface BookService {

	BookListDto getBookList();

	AddBookResponseDto addBook(AddBookDto addBookDto);

}
