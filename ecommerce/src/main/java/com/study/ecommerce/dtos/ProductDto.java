package com.study.ecommerce.dtos;

import com.study.ecommerce.entities.Category;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//A Data Transfer Object (DTO) is a design pattern used to create simple Java objects that carry data between different layers of an application or between a client and a server. In Spring Boot, a DTO typically contains only data fields, constructors, getters, and setters, without containing any business or database logic

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

	private Integer id;

	@NotNull
	@NotBlank
	private String name;

	@NotNull
	@NotBlank(message = "Description cannot be blank.")
	private String description;

	@Min(1)
	private Integer price;

	private Category category;

	private String imageUrl;
}
