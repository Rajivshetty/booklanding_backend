
package com.book.lending.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.lending.dto.BorrowBookRequestDto;
import com.book.lending.dto.BorrowBookResponseDto;
import com.book.lending.service.BorrowBookService;

/**
 * @author User1
 *
 */

@RestController
public class BorrowBookController {

	@Autowired
	private BorrowBookService borrowBookService;
	
	@PostMapping("api/books")
	public ResponseEntity<BorrowBookResponseDto> issueBook(@RequestBody BorrowBookRequestDto borrowBookRequestDto ) {
		
	return new ResponseEntity<BorrowBookResponseDto>(borrowBookService.issueBookService(borrowBookRequestDto.getBookId(), borrowBookRequestDto.getUserId()), HttpStatus.CREATED)	;

		
	}
	

}
