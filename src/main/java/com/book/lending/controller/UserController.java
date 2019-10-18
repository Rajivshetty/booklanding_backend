package com.book.lending.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.lending.dto.UserRequestDto;
import com.book.lending.dto.UserResponseDto;
import com.book.lending.service.BorrowBookServiceImpl;
import com.book.lending.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "*", "*/" }, allowedHeaders = { "*", "*/" })

/**
 * 
 * @author mahesh
 *
 */
public class UserController {

	public static final Logger log = LoggerFactory.getLogger(BorrowBookServiceImpl.class);

	@Autowired
	UserService userService;

	/**
	 * method is used to register a user
	 * @param userRequestDto gives user details for registration
	 * @return UserResponseDto with message
	 */

	@PostMapping("/register")
	public ResponseEntity<UserResponseDto> addUser(@RequestBody UserRequestDto userRequestDto) {

		log.debug("user registration method in user controller");
		return new ResponseEntity<>(userService.addUser(userRequestDto), HttpStatus.OK);
	}
}
