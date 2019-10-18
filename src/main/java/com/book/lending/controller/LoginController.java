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

import com.book.lending.dto.LoginDTO;
import com.book.lending.dto.LoginResponseDTO;
import com.book.lending.exception.BookLendingException;
import com.book.lending.service.LoginService;

/**
 * @author shiva
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "*", "*/" }, allowedHeaders = { "*", "*/" })

public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	LoginService loginService;

	/**
	 * @param LoginDTO
	 * 
	 * This method is used for login
	 * @throws BookLendingException 
	 */
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> getUser(@RequestBody LoginDTO loginDTO) throws BookLendingException {
		LOGGER.info("LoginController.class");
		return new ResponseEntity<>(loginService.getUserDetails(loginDTO), HttpStatus.OK);

	}

}
