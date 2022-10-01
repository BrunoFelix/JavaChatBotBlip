package com.chatbot.blip.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="cart_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    public Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_cart_id")
    public ShoppingCart shoppingCart;

    @Column(name = "quantity", nullable = false)
    public int quantity;

    @Column(name = "value", nullable = false)
    public double value;

    @Column(name = "delivery_address")
    public LocalDateTime deliveryAddress;

    @Column(name = "delivery_date")
    public LocalDateTime deliveryDate;
}
