package com.study.ecommerce.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.ecommerce.dtos.ProductDto;
import com.study.ecommerce.entities.Product;
import com.study.ecommerce.repositories.ProductRepository;
import com.study.ecommerce.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProductRepository productRepository;

	public ProductDto addProduct(ProductDto productDto) {
//		map method will help to convert dto into entity and vice versa.
		Product product = modelMapper.map(productDto, Product.class);

//		Save method save the objects into the database table and returns also, that we have saved in saveProduct variable
		Product saveProduct = productRepository.save(product);

		return modelMapper.map(saveProduct, ProductDto.class);
	}

	public List<ProductDto> getAllProduct() {
//		findAll returns all products from product table
		List<Product> products = productRepository.findAll();
//		Converts List of products into productDto.class using Stream API bcuz modelMapper cannot convert multiple objects at a time.
		List<ProductDto> productDtoList = products.stream().map((p) -> modelMapper.map(p, ProductDto.class)).toList();
		return productDtoList;
	}

	public ProductDto getProductById(Integer id) {
//		Yaha pe findBy method mujhe Optional return krega, means jo id di gyi hai wo hai to theek or nahi to..,uske pas ek method hai orelseThrow , means id hai to dedo wrna exception throw krdo...
		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found."));
		return modelMapper.map(product, ProductDto.class);
	}

	public ProductDto updateProduct(Integer id, ProductDto productDto) {
		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));

		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());

		Product updatedProduct = productRepository.save(product);

		return modelMapper.map(updatedProduct, ProductDto.class);
	}

	public void deleteProduct(Integer id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
		productRepository.delete(product);
	}

}

// @Service -It creates the bean and it marks the class as a buisness layer 
