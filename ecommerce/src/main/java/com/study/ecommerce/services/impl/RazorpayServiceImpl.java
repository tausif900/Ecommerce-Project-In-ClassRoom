package com.study.ecommerce.services.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.study.ecommerce.entities.Cart;
import com.study.ecommerce.entities.CartItem;
import com.study.ecommerce.services.CartService;
import com.study.ecommerce.services.RazorpayService;

@Service
public class RazorpayServiceImpl implements RazorpayService {

	@Value("${razorpay.key}")
	private String razorpayKey;

	@Value("${razorpay.secret}")
	private String razorpaySecret;

	@Autowired
	private CartService cartService;

	@Override
	public Map<String, Object> createOrder(String userId, Integer addressId) throws RazorpayException {

		Cart cart = cartService.getCart(userId);

		List<CartItem> cartItems = cart.getCartItems();

		int total = 0;

		for (CartItem cartItem : cartItems) {
			total += cartItem.getQuantity() * cartItem.getProduct().getPrice();
		}

		RazorpayClient client = new RazorpayClient(razorpayKey, razorpaySecret);

		JSONObject order = new JSONObject();
		order.put("amount", total * 100);
		order.put("currency", "INR");
		order.put("receipt", "receipt_" + UUID.randomUUID().toString().substring(0, 6));

		client.orders.create(order);

		return null;
	}

	@Override
	public boolean verifyPaymentSignature(String razorpayPaymentId, String razorpayOrderId, String razorpaySignature,
			String userId, Integer addressId) {
		// TODO Auto-generated method stub
		return false;
	}

}
