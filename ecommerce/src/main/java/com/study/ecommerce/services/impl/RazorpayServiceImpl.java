package com.study.ecommerce.services.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;
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

		Order razorpayOrder = client.orders.create(order);
		JSONObject json = razorpayOrder.toJson();

		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();

		map.put("id", json.get("id"));
		map.put("amount", json.get("amount"));
		map.put("currency", json.get("currency"));
		map.put("receipt", json.get("receipt"));
		map.put("status", json.get("status"));

		return map;
	}

	@Override
	public boolean verifyPaymentSignature(String razorpayPaymentId, String razorpayOrderId, String razorpaySignature,
			String userId, Integer addressId) {
		JSONObject options = new JSONObject();
		options.put("razorpay_order_id", razorpayOrderId);
		options.put("razorpay_payment_id", razorpayPaymentId);
		options.put("razorpay_signature", razorpaySignature);

		try {
			boolean isValid = Utils.verifyPaymentSignature(options, razorpaySecret);
			if (!isValid) {
				return false;
			}
//			order generation in spring boot app (order entity)
		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
