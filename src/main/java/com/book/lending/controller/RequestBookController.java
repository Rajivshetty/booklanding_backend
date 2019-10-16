/**
 * 
 */
package com.book.lending.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.lending.dto.RequestBook;
import com.book.lending.dto.ResponseDto;
import com.book.lending.service.RequestBookService;

/**
 * @author shiva
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "*", "*/" }, allowedHeaders = { "*", "*/" })
public class RequestBookController {

	@Autowired
	RequestBookService requestBookService;

	@PostMapping("/book")
	public ResponseEntity<ResponseDto> requestBook(@RequestBody RequestBook requestBook) {

		return new ResponseEntity<>(requestBookService.requestingBook(requestBook), HttpStatus.CREATED);

	}
}
