package com.book.lending.service;

import static com.book.lending.util.BookUtil.CREDENTIALS_EMPTY;
import static com.book.lending.util.BookUtil.LOGIN_FAILURE;
import static com.book.lending.util.BookUtil.LOGIN_SUCCESS;
import static com.book.lending.util.BookUtil.LOGIN_SUCCESS_CODE;

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

/**
 * @author shiva
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger lOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	/**
	 * @param LoginDTO
	 * @throws BookLendingException
	 * @return LoginResponseDTO This method check whether the credentials are
	 *         correct or in correct
	 */
	@Override
	public LoginResponseDTO getUserDetails(LoginDTO loginDTO) {

		lOGGER.info("Inside LoginServiceImpl");

		String userName = loginDTO.getUserEmail();
		String password = loginDTO.getPassword();

		lOGGER.info("userName:{} Password:{}", userName, password);

		LoginResponseDTO loginResponseDTO = null;

		if (userName.equals("") || password.equals("")) {

			throw new BookLendingException(CREDENTIALS_EMPTY);

		}

		else {
			Optional<User> userList = userRepository.findByUserEmailAndPassword(userName, password);

			if (!(userList.isPresent())) {
				throw new BookLendingException(LOGIN_FAILURE);

			}

			else {

				loginResponseDTO = new LoginResponseDTO();
				User user = userList.get();
				loginResponseDTO.setUserName(user.getUserName());
				loginResponseDTO.setUserId(user.getUserId());
				loginResponseDTO.setMessage(LOGIN_SUCCESS);
				loginResponseDTO.setStatusCode(LOGIN_SUCCESS_CODE);

			}

		}

		return loginResponseDTO;
	}

}
