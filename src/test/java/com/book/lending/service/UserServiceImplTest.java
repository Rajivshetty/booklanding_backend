package com.book.lending.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.book.lending.dto.UserRequestDto;
import com.book.lending.dto.UserResponseDto;
import com.book.lending.entity.User;
import com.book.lending.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	@InjectMocks
	UserServiceImpl userService;

	@Mock
	UserRepository userRepo;

	@Before
	public void setUp() {

	}

	@Test
	public void testAddUser() {
		UserRequestDto userRequestDto = null;
		UserResponseDto userResponseDto = null;

		userRequestDto = new UserRequestDto();
		userRequestDto.setAddress("Bng");
		userRequestDto.setPassword("mahesh");
		userRequestDto.setPhoneNo(9898L);
		userRequestDto.setUserEmail("mahi@gmail.com");
		userRequestDto.setUserName("Mahesh");

		userResponseDto = new UserResponseDto();
		userResponseDto.setMessage("Register Successfully");
		userResponseDto.setStatusCode(HttpStatus.OK.value());
		User user = new User();
		user.setAddress("Bng");
		Mockito.when(userRepo.save(Mockito.any())).thenReturn(user);
		UserResponseDto userResponseDto1 = userService.addUser(userRequestDto);
		assertEquals(userResponseDto.getMessage(), userResponseDto1.getMessage());
	}

}
