package com.book.lending.service;

import org.springframework.stereotype.Service;

import com.book.lending.dto.LoginDTO;
import com.book.lending.dto.LoginResponseDTO;

@Service
public interface LoginService {
	
	public LoginResponseDTO getUserDetails(LoginDTO loginDTO);

}
