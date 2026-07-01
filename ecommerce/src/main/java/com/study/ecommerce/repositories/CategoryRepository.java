package com.study.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.study.ecommerce.entities.Category;
import com.study.ecommerce.projection.CategoryProjection;

@RepositoryRestResource(path = "categories", excerptProjection = CategoryProjection.class)
@CrossOrigin
//  The @RepositoryRestResource annotation in Spring Data REST automatically exposes your database repositories as hypermedia-driven RESTful endpoints, eliminating the need to write manual @RestController or service classes for basic CRUD operations.
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
