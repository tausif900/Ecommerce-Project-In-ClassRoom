package com.study.ecommerce.services;

import com.study.ecommerce.dtos.UserDto;

public interface UserService {

	UserDto register(UserDto userDto);

	boolean emailExist(String email);
}
