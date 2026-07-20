package com.study.ecommerce.services;

import java.util.List;

import com.study.ecommerce.entities.Address;

public interface AddressService {

	Address addAddress(String userId, Address address);

	List<Address> getAddresses(String userId);
}
