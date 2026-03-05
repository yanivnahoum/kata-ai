package com.att.training.kata.ai.models;

import java.math.BigDecimal;
import java.util.Objects;

public record CartItem(String id, String name, BigDecimal unitPrice, int quantity, Category category) {

    public CartItem {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(unitPrice, "unitPrice must not be null");
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity must be >= 0");
        }
        if (unitPrice.signum() < 0) {
            throw new IllegalArgumentException("unitPrice must be >= 0");
        }
        category = category == null ? Category.OTHER : category;
    }
}
