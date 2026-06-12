package com.study.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.study.ecommerce.entities.Product;

//	In Spring Boot, JpaRepository is a Spring Data JPA interface that provides full CRUD operations, pagination, sorting, and batch deletion capabilities for a specific database entity. Meaning you do not have to write SQL queries or manual Data Access Object (DAO) boilerplate code for common database tasks.By extending JpaRepository, our interface automatically inherits a wide array of ready-to-use methods.
//	We should use JpaRepository in Spring Boot because it eliminates boilerplate data-access code by providing a fully implemented, ready-to-use CRUD and database management layer. By simply Creating an interface that extends JpaRepository, Spring Boot automatically generates the necessary database operations at runtime without we having to write any SQL or implementation code.
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
