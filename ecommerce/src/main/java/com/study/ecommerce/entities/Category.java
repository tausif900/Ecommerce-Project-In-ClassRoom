package com.study.ecommerce.entities;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;

	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "category")	//We use the @OneToMany annotation in Java persistence frameworks (like Hibernate 						and Spring Data JPA) to map a parent-child database relationship where a single 						entity (the "one") is associated with multiple instances of another entity (the 						"many"). It allows us to hold a collection of child objects directly inside the 						parent class (e.g., a List<Product> inside a Department products).
	private List<Product> products;
	

}
