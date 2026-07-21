package com.study.ecommerce.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Integer totalAmount;

	private String status;

	private String paymentStatus;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@ManyToOne
	@JsonIgnore
	private User user;

	@ManyToOne
	private Address address;

	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems;

}
