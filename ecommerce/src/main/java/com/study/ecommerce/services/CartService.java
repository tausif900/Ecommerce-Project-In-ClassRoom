package com.study.ecommerce.services;

import com.study.ecommerce.entities.Cart;
import com.study.ecommerce.entities.CartItem;

public interface CartService {

// to fetch the cart
	Cart getCart(String userId);

//	Add to cart
	Cart addToCart(String userId, Integer productId, CartItem cartItem);

}
