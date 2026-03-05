package com.att.training.kata.ai.engine;

import com.att.training.kata.ai.models.AppliedRule;
import com.att.training.kata.ai.models.Cart;
import com.att.training.kata.ai.models.CartItem;
import com.att.training.kata.ai.models.DiscountResult;
import com.att.training.kata.ai.rules.CustomerDiscountRule;
import com.att.training.kata.ai.rules.DiscountRule;
import com.att.training.kata.ai.rules.TotalDiscountRule;
import com.att.training.kata.ai.utils.DiscountConstants;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public final class DefaultDiscountEngine implements DiscountEngine {
    private final List<DiscountRule> rules;

    public DefaultDiscountEngine() {
        this(List.of(new TotalDiscountRule(), new CustomerDiscountRule()));
    }

    public DefaultDiscountEngine(List<DiscountRule> rules) {
        this.rules = List.copyOf(Objects.requireNonNull(rules, "rules must not be null"));
    }

    @Override
    public DiscountResult calculateDiscount(Cart cart) {
        Objects.requireNonNull(cart, "cart must not be null");

        BigDecimal originalTotal = calculateOriginalTotal(cart);
        List<AppliedRule> appliedRules = rules.stream()
            .flatMap(rule -> rule.apply(cart, originalTotal).stream())
            .toList();

        BigDecimal totalDiscount = appliedRules.stream()
            .map(AppliedRule::discountAmount)
            .reduce(DiscountConstants.ZERO, BigDecimal::add);

        BigDecimal finalTotal = originalTotal.add(totalDiscount);
        if (finalTotal.signum() < 0) {
            finalTotal = DiscountConstants.ZERO;
        }

        return new DiscountResult(originalTotal, finalTotal, appliedRules);
    }

    private static BigDecimal calculateOriginalTotal(Cart cart) {
        return cart.items().stream()
            .map(DefaultDiscountEngine::lineTotal)
            .reduce(DiscountConstants.ZERO, BigDecimal::add);
    }

    private static BigDecimal lineTotal(CartItem item) {
        return item.unitPrice().multiply(BigDecimal.valueOf(item.quantity()));
    }
}
