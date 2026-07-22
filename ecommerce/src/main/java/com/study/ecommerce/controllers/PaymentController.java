package com.study.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.RazorpayException;
import com.study.ecommerce.entities.User;
import com.study.ecommerce.services.RazorpayService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private RazorpayService razorpayService;

	@PostMapping("/create-order/${addressId}")
	public ResponseEntity<?> createOrder(@AuthenticationPrincipal User user, @PathVariable Integer addressId)
			throws RazorpayException {
		return ResponseEntity.ok(razorpayService.createOrder(user.getId(), addressId));
	}
}
