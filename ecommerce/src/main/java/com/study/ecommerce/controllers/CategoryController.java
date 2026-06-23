package com.study.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.ecommerce.dtos.ProductDto;
import com.study.ecommerce.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PutMapping("/{categoryId}/products/{productId}")
	public ResponseEntity<Void> addProductToCategory(@PathVariable Integer categoryId,
			@PathVariable Integer productId) {
		categoryService.addProductToCategory(categoryId, productId);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{categoryId}/products")
	public ResponseEntity<List<ProductDto>> getProducts(@PathVariable Integer categoryId) {
		return ResponseEntity.ok(categoryService.getProducts(categoryId));
	}
}
