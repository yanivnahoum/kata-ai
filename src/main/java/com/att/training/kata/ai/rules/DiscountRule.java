package com.att.training.kata.ai.rules;

import com.att.training.kata.ai.models.AppliedRule;
import com.att.training.kata.ai.models.Cart;
import java.math.BigDecimal;
import java.util.List;

@FunctionalInterface
public interface DiscountRule {
    List<AppliedRule> apply(Cart cart, BigDecimal originalTotal);
}
