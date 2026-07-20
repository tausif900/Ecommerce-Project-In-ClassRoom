package com.study.ecommerce.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.ecommerce.entities.Address;
import com.study.ecommerce.entities.User;
import com.study.ecommerce.repositories.AddressRepository;
import com.study.ecommerce.repositories.UserRepository;
import com.study.ecommerce.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address addAddress(String userId, Address address) {

		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
		address.setUser(user);
		return addressRepository.save(address);
	}

	@Override
	public List<Address> getAddresses(String userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
		return user.getAddresses();
	}

}