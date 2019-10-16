package com.book.lending.controller;

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
import com.book.lending.service.UserService;

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
public class UserController {

	@Autowired
	UserService userService;
	
	/**
	 * 
	 * @param userRequestDto gives user details for registration
	 * @return  UserResponseDto with message
	 */
	
	@PostMapping("/registration")
	public ResponseEntity<UserResponseDto> addUser(@RequestBody UserRequestDto userRequestDto) {

		log.info("user registration method in user controller");
		return new ResponseEntity<>(userService.addUser(userRequestDto), HttpStatus.OK);
	}
}
