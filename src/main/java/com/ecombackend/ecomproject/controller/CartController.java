package com.ecombackend.ecomproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecombackend.ecomproject.model.Cart;
import com.ecombackend.ecomproject.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    @CrossOrigin
    public List<Cart> getAllCarts() {
        return cartService.findAll();
    }

    @PostMapping("/carts")
    @CrossOrigin
    public Cart addCart(@RequestBody Cart cart) {
        return cartService.save(cart);
    }

    // Additional endpoint methods for update, delete, etc.
}
