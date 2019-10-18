package com.book.lending.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.book.lending.dto.UserRequestDto;
import com.book.lending.dto.UserResponseDto;
import com.book.lending.entity.User;
import com.book.lending.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	
	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;
	
	UserRequestDto userRequestDto = null;
	UserResponseDto userResponseDto = null;
	
	@Before
	public void setUp() {
		userRequestDto = new UserRequestDto();
		userRequestDto.setAddress("Bng");
		userRequestDto.setPassword("mahesh");
		userRequestDto.setPhoneNo(9898L);
		userRequestDto.setUserEmail("mahi@gmail.com");
		userRequestDto.setUserName("Mahesh");
		
		userResponseDto = new UserResponseDto();
		userResponseDto.setMessage("Register Successfully");
		userResponseDto.setStatusCode(HttpStatus.OK.value());
		
	}
	
	@Test
	public void testAddUser() {
		User user = new User();
		BeanUtils.copyProperties(userRequestDto, user);
		Mockito.when(userService.addUser(userRequestDto)).thenReturn(userResponseDto);
		ResponseEntity<UserResponseDto> obj = userController.addUser(userRequestDto);
		assertEquals(userResponseDto.getMessage(), obj.getBody().getMessage());
	}

}
