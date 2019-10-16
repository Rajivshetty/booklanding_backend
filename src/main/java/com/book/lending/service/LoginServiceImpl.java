package com.book.lending.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.lending.dto.LoginDTO;
import com.book.lending.dto.LoginResponseDTO;
import com.book.lending.entity.User;
import com.book.lending.exception.BookLendingException;
import com.book.lending.repository.UserRepository;
import com.book.lending.util.BookUtil;


@Service
public class LoginServiceImpl implements LoginService {
	
	private static final Logger lOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public LoginResponseDTO getUserDetails(LoginDTO loginDTO) {
		
		lOGGER.info("Inside LoginServiceImpl");

		String userName = loginDTO.getUserEmail();
		String password = loginDTO.getPassword();
		
		lOGGER.info(userName);
		lOGGER.info(password);

		LoginResponseDTO loginResponseDTO = null;

		if (userName.equals("") || password.equals("")) {

			throw new BookLendingException(BookUtil.CREDENTIALS_EMPTY);

		}

		else {
			Optional<User> userList = userRepository.findByUserEmailAndPassword(userName, password);

			if (!(userList.isPresent())) {
				throw new BookLendingException(BookUtil.LOGIN_FAILURE);

			}

			else {

				loginResponseDTO = new LoginResponseDTO();
				User user = userList.get();
				loginResponseDTO.setUserName(user.getUserName());
				loginResponseDTO.setUserId(user.getUserId());
				loginResponseDTO.setMessage(BookUtil.LOGIN_SUCCESS);
				loginResponseDTO.setStatusCode(BookUtil.LOGIN_SUCCESS_CODE);

			}

		}

		return loginResponseDTO;
	}

}
