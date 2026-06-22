package com.study.ecommerce.dtos;

import com.study.ecommerce.enums.Role;
import com.study.ecommerce.validators.PasswordMatch;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@PasswordMatch
//	UserDto is a copy of user class.
public class UserDto {

	private String id;

	@NotNull(message = "first name can't be null")
	@NotBlank(message = "first name can't be blank")
	@Size(min = 2, max = 60)
	private String firstName;

	@NotNull(message = "last name can't be null")
	@NotBlank(message = "last name can't be blank")
	@Size(min = 2, max = 60)
	private String lastName;

	@Pattern(regexp = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$")
	private String email;

	@Pattern(regexp = "^((?=\\S*?[A-Z])(?=\\S*?[a-z])(?=\\S*?[0-9]).{6,})\\S$")
	private String password;

	private String confirmPassword;

	private Role role;
}
