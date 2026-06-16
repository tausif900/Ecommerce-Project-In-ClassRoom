package com.study.ecommerce.services;

import java.util.List;

import com.study.ecommerce.dtos.ProductDto;

//  We create a service layer (classes annotated with @Service) in Spring Boot to isolate and manage the core business logic of an application. This acts as a vital bridge between the controller layer (which handles HTTP requests) and the repository layer (which interacts with the database), ensuring a clean separation of concerns.

public interface ProductService {
//	Interface we have created here so it acts as a blueprint here
//	addProduct takes ProductDto ka obj and then jo Database me obj save hua h wahi mujhe return krdo.
	ProductDto addProduct(ProductDto productDto);

	List<ProductDto> getAllProduct();

	ProductDto getProductById(Integer id);

	ProductDto updateProduct(Integer id, ProductDto productDto);

	void deleteProduct(Integer id);
}
