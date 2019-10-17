package com.book.lending.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.book.lending.dto.LoginDTO;
import com.book.lending.dto.LoginResponseDTO;
import com.book.lending.entity.User;
import com.book.lending.exception.BookLendingException;
import com.book.lending.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTest {

	@Mock
	UserRepository userRepository;

	@InjectMocks
	LoginServiceImpl loginServiceImpl;

	@Test
	public void testGetUserDetails() {
		User user = new User();

		user.setUserId(1);
		user.setUserName("raja@gmail.com");
		user.setPassword("raja@123");

		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUserEmail("raja@gmail.com");
		loginDTO.setPassword("raja@123");
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
		loginResponseDTO.setStatusCode(201);
		Mockito.when(userRepository.findByUserEmailAndPassword(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(Optional.of(user));

		LoginResponseDTO actualValue = loginServiceImpl.getUserDetails(loginDTO);

		assertEquals(loginResponseDTO.getStatusCode(), actualValue.getStatusCode());

	}

	@Test(expected = BookLendingException.class)
	public void testGetUserDetailsFailure() {
		User user = new User();

		user.setUserId(1);
		user.setUserName("raja@gmail.com");
		user.setPassword("raja@123");

		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUserEmail("rani@gmail.com");
		loginDTO.setPassword("raja@123");
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
		loginResponseDTO.setStatusCode(201);

		loginServiceImpl.getUserDetails(loginDTO);

	}

	@Test(expected = BookLendingException.class)
	public void testEmptyCredentials() {
		User user = new User();

		user.setUserId(1);
		user.setUserName("raja@gmail.com");
		user.setPassword("raja@123");

		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUserEmail("");
		loginDTO.setPassword("raja@123");
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
		loginResponseDTO.setStatusCode(201);

		loginServiceImpl.getUserDetails(loginDTO);

	}

}
