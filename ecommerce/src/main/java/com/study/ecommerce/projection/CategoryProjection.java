package com.study.ecommerce.projection;

//	In Spring Boot, projections allow you to retrieve only specific fields or a subset of data from a database query instead of fetching full database entities.
public interface CategoryProjection {

	Integer getId();

	String getName();
}
