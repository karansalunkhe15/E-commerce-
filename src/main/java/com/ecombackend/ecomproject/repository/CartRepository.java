package com.ecombackend.ecomproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecombackend.ecomproject.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    // Additional custom methods can be defined here
}
