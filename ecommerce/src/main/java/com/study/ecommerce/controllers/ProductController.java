package com.study.ecommerce.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.study.ecommerce.dtos.ProductDto;
import com.study.ecommerce.services.FileService;
import com.study.ecommerce.services.ProductService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private FileService fileService;

	@Value("${product.image.path}")
	private String imagePath;

//	-----------------------------------------------------------------------------
//	POST -- localhost:8080/products
//	-----------------------------------------------------------------------------
	@PostMapping
	public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody ProductDto product) {
		return new ResponseEntity<ProductDto>(productService.addProduct(product), HttpStatus.CREATED);
	}

//	-------------------------------------
//	GET -- localhost:8080/products
//	-------------------------------------
	@GetMapping
	public ResponseEntity<List<ProductDto>> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProduct());
	}

//	-------------------------------------
//	GET -- localhost:8080/products/{id}
//	-------------------------------------
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable Integer id) {
		return ResponseEntity.ok(productService.getProductById(id));
	}

//	-------------------------------------
//	DELETE -- localhost:8080/products/{id}
//	-------------------------------------
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> deleteProduct(@PathVariable Integer id) {
		productService.deleteProduct(id);
		HashMap<String, String> response = new HashMap<String, String>();
		response.put("message", "Product deleted successfully.");
		return ResponseEntity.ok(response);
	}

//	-------------------------------------
//	PUT -- localhost:8080/products/{id}
//	-------------------------------------
	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> updatedProduct(@PathVariable Integer id, @RequestBody ProductDto productDto) {
		return ResponseEntity.ok(productService.updateProduct(id, productDto));
	}

//	-------------------------------------
//	POST -- localhost:8080/products/upload-image/{id}
//	-------------------------------------
	@PostMapping("/upload-image/{id}")
	public ResponseEntity<String> uploadImage(@RequestParam("productImage") MultipartFile file,
			@PathVariable Integer id) {

		String fileName = fileService.uploadImage(file, imagePath);
		ProductDto dto = productService.getProductById(id);
		dto.setImageUrl(fileName);
		productService.updateProduct(id, dto);

		return ResponseEntity.ok(fileName);

	}

//	-------------------------------------
//	POST -- localhost:8080/products/get-image/{id}
//	-------------------------------------
	@GetMapping("/get-image/{id}")
	public void getImage(@PathVariable Integer id, HttpServletResponse response) {
		ProductDto dto = productService.getProductById(id);
		InputStream image = fileService.getResource(imagePath, dto.getImageUrl());
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		try {
			StreamUtils.copy(image, response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
