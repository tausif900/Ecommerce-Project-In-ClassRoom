package com.study.ecommerce.dtos;

import com.study.ecommerce.entities.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//A Data Transfer Object (DTO) is a design pattern used to create simple Java objects that carry data between different layers of an application or between a client and a server. In Spring Boot, a DTO typically contains only data fields, constructors, getters, and setters, without containing any business or database logic

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

	private Integer id;

	private String name;

	private String description;

	private Integer price;

	private Category category;
}
