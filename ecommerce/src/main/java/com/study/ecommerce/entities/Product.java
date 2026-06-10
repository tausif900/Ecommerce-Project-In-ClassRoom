package com.study.ecommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // @Data at the class level automatically generates getters, setters, standard
		// methods, and required constructors during compilation, keeping our source
		// code clean and readable.
@NoArgsConstructor // @NoArgsConstructor annotation from the Lombok Library automatically generates
					// a constructor with no arguments, which eliminates boilerplate code and
					// satisfies framework requirements.
@AllArgsConstructor // @AllArgsConstructor annotation automatically generates a constructor with one
					// parameter for every field in a class, eliminating repetitive boilerplate
					// code.
@Entity // @Entity annotation in Spring Boot is used to mark a Java class as a
		// persistent data model, signaling to the underlying Object-Relational Mapping
		// (ORM) framework—usually Hibernate—that this class should be mapped directlyto
		// a relational database table
public class Product {
	@Id // @Id annotation is used to designate a specific field in an entity class as
		// the primary key of its corresponding database table.It tells the
		// object-relational mapping (ORM) framework which database column should be
		// treated as the primary key.
	@GeneratedValue(strategy = GenerationType.AUTO) // @GeneratedValue annotation in Spring Boot (via JPA/Hibernate) is
													// used to automatically generate unique values for primary key
													// fields. You do not need to manually compute or set IDs before
													// saving data.
	private Integer id;

	@Column(nullable = false, length = 60) // we use the @Column annotation to customize the mapping between a Java
											// class field and a relational database table column. JPA automatically
											// maps your Java fields to database columns using default naming
											// conventions, we must use @Column.
	private String name;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private Integer price;

	@ManyToOne
	private Category category;

}
