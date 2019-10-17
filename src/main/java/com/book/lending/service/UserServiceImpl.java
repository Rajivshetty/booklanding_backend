package com.book.lending.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.book.lending.dto.UserRequestDto;
import com.book.lending.dto.UserResponseDto;
import com.book.lending.entity.User;
import com.book.lending.repository.UserRepository;
import com.book.lending.util.BookUtil;

@Service

public class UserServiceImpl implements UserService {
	private static final Logger log = LoggerFactory.getLogger(RequestBookServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public UserResponseDto addUser(UserRequestDto userRequestDto) {

		log.info("registraton of the user  in user service");

		User user = new User();
		BeanUtils.copyProperties(userRequestDto, user);
		userRepository.save(user);
		UserResponseDto userResponseDto = new UserResponseDto();

		userResponseDto.setMessage(BookUtil.REGISTER_SUCCESS);

		userResponseDto.setStatusCode(HttpStatus.OK.value());
		return userResponseDto;
	}

}
