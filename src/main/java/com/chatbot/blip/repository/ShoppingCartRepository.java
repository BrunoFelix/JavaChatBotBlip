package com.chatbot.blip.repository;

import com.chatbot.blip.model.ShoppingCart;
import com.chatbot.blip.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

    Optional<ShoppingCart> findFirstByUserOrderByIdDesc(User user);
}