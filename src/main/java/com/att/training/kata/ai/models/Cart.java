package com.att.training.kata.ai.models;

import java.util.List;
import java.util.Objects;

public record Cart(String customerId, List<CartItem> items) {

    public Cart {
        customerId = Objects.requireNonNullElse(customerId, "");
        items = List.copyOf(Objects.requireNonNull(items, "items must not be null"));
    }
}
