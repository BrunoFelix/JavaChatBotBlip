package com.chatbot.blip.repository;

import com.chatbot.blip.model.CartItem;
import com.chatbot.blip.model.Product;
import com.chatbot.blip.model.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {

    List<CartItem> findByShoppingCartOrderByIdDesc(ShoppingCart shoppingCart);
    void deleteByShoppingCart(ShoppingCart shoppingCart);
    void deleteByShoppingCartAndProduct(ShoppingCart shoppingCart, Product product);
}
