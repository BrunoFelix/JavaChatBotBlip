package com.chatbot.blip.repository;

import com.chatbot.blip.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByIdIn(List<Long> ids);
    List<Product> findByNameContainingIgnoreCase(String name);
}
