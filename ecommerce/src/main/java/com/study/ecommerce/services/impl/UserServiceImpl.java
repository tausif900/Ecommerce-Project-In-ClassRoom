package com.study.ecommerce.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.ecommerce.dtos.UserDto;
import com.study.ecommerce.entities.User;
import com.study.ecommerce.enums.Role;
import com.study.ecommerce.repositories.UserRepository;
import com.study.ecommerce.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto register(UserDto userDto) {
		userDto.setRole(Role.ROLE_CUSTOMER);
		User user = modelMapper.map(userDto, User.class);
		User savedUser = userRepository.save(user);

		return modelMapper.map(savedUser, UserDto.class);
	}

}
