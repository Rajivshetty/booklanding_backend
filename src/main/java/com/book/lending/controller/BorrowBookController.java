
package com.book.lending.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.lending.dto.BorrowBookRequestDto;
import com.book.lending.dto.BorrowBookResponseDto;
import com.book.lending.service.BorrowBookService;

/**
 * @author User1
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "*", "*/" }, allowedHeaders = { "*", "*/" })
public class BorrowBookController {

	@Autowired
	private BorrowBookService borrowBookService;
	
	@PostMapping("/books/borrow")
	public ResponseEntity<BorrowBookResponseDto> issueBook(@RequestBody BorrowBookRequestDto borrowBookRequestDto ) {
		
	return new ResponseEntity<BorrowBookResponseDto>(borrowBookService.issueBookService(borrowBookRequestDto.getBookId(), borrowBookRequestDto.getUserId()), HttpStatus.CREATED)	;

		
	}
	

}
