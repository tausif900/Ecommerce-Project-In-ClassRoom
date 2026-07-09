package com.study.ecommerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.study.ecommerce.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

//	custom query method
	boolean existsByEmail(String email); // this method is checking whether the email is already exist or not,on basis
											// of that it returns true or false.

//	custom method,this method search using email in the database and return it's Object.
	Optional<User> findByEmail(String email);
}
