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
		// TODO Auto-generated method stub
		return null;
	}

	public ProductDto getProductById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductDto updateProduct(Integer id, ProductDto productDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteProduct(Integer id) {
		// TODO Auto-generated method stub

	}

}

// @Service -It creates the bean and it marks the class as a buisness layer 
