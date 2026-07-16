package com.study.ecommerce.services.impl;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.ecommerce.entities.Cart;
import com.study.ecommerce.entities.CartItem;
import com.study.ecommerce.entities.Product;
import com.study.ecommerce.entities.User;
import com.study.ecommerce.repositories.CartItemRepository;
import com.study.ecommerce.repositories.CartRepository;
import com.study.ecommerce.repositories.ProductRepository;
import com.study.ecommerce.repositories.UserRepository;
import com.study.ecommerce.services.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartItemRepository cartItemRepository;

	@Override
	public Cart getCart(String userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not Found"));
		Cart cart = user.getCart();
		if (cart == null) {
			cart = new Cart();
			cart.setUser(user);
			cart.setCartItems(new ArrayList<CartItem>());
			cart = cartRepository.save(cart);
		}
		return cart;
	}

	@Override
	public Cart addToCart(String userId, Integer productId, CartItem cartItem) {
		Cart cart = getCart(userId);
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new RuntimeException("Product not found"));
		for (CartItem item : cart.getCartItems()) {
			if (item.getProduct().getId().equals(productId)) {
				item.setQuantity();
			}
		}

		cartItemRepository.save(cartItem);

		return getCart(userId);
	}

	@Override
	public void deleteCartItem(Integer cartItemId) {
		CartItem cartItem = cartItemRepository.findById(cartItemId)
				.orElseThrow(() -> new RuntimeException("Cart item not found"));

		cartItemRepository.delete(cartItem);
	}

}
