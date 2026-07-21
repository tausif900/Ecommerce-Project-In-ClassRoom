package com.study.ecommerce.services;

import java.util.Map;

import com.razorpay.RazorpayException;

public interface RazorpayService {

	Map<String, Object> createOrder(String userId, Integer addressId) throws RazorpayException;

	boolean verifyPaymentSignature(String razorpayPaymentId, String razorpayOrderId, String razorpaySignature, String userId,
			Integer addressId);

}
