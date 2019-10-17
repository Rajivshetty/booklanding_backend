package com.book.lending.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.book.lending.dto.LoginDTO;
import com.book.lending.dto.LoginResponseDTO;
import com.book.lending.service.LoginServiceImpl;
import com.book.lending.util.BookUtil;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

	@Mock
	LoginServiceImpl loginServiceImpl;

	@InjectMocks
	LoginController loginController;

	@Test
	public void testGetUser() {
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUserEmail("raja@gmail.com");
		loginDTO.setPassword("raja@123");
		
		LoginResponseDTO loginResponseDTO=new LoginResponseDTO();
		loginResponseDTO.setUserId(1);
		loginResponseDTO.setUserName("raja@gmail.com");
		loginResponseDTO.setMessage(BookUtil.LOGIN_SUCCESS);
		loginResponseDTO.setStatusCode(BookUtil.LOGIN_SUCCESS_CODE);
		
		Mockito.when(loginServiceImpl.getUserDetails(loginDTO)).thenReturn(loginResponseDTO);
		LoginResponseDTO actualValue=loginServiceImpl.getUserDetails(loginDTO);
		assertEquals(loginResponseDTO.getStatusCode(), actualValue.getStatusCode());
		
	}

}

