package com.book.lending.service;

import org.springframework.stereotype.Service;

import com.book.lending.dto.UserRequestDto;
import com.book.lending.dto.UserResponseDto;

@Service
public interface UserService {

	UserResponseDto addUser(UserRequestDto userRequestDto);

}
