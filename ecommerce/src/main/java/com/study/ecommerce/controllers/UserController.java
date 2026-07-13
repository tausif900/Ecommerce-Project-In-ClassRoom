package com.study.ecommerce.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.ecommerce.dtos.UserDto;
import com.study.ecommerce.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@CrossOrigin()
public class UserController {

	@Autowired
	private UserService userService;


//	---------------------------------------
//	POST - localhost:8080/users
//	---------------------------------------
	@PostMapping
	public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto) {
		return new ResponseEntity<UserDto>(userService.register(userDto), HttpStatus.CREATED);
	}

//	-----------------------------------------------
//	GET localhost:8080/users/check-email?email=a@itvedant.com
//	-----------------------------------------------

	@GetMapping("/check-email")
	public boolean checkEmail(@RequestParam String email) {
		return userService.emailExist(email);
	}
}
