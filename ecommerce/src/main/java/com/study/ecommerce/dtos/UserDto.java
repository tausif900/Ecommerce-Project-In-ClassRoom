package com.study.ecommerce.dtos;

import com.study.ecommerce.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//	UserDto is a copy of user class.
public class UserDto {

	private String id;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private String confirmPassword;
	
	private Role role;
}
