package com.att.training.kata.ai.engine;

import com.att.training.kata.ai.models.Cart;
import com.att.training.kata.ai.models.DiscountResult;

public interface DiscountEngine {
    DiscountResult calculateDiscount(Cart cart);
}
