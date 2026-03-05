package com.att.training.kata.ai.rules;

import com.att.training.kata.ai.models.AppliedRule;
import com.att.training.kata.ai.models.Cart;
import com.att.training.kata.ai.utils.DiscountConstants;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

public final class CustomerDiscountRule implements DiscountRule {

    @Override
    public List<AppliedRule> apply(Cart cart, BigDecimal originalTotal) {
        String customerId = cart.customerId().toLowerCase(Locale.ROOT);
        if (!customerId.startsWith("vip")) {
            return List.of();
        }

        BigDecimal discountAmount = originalTotal.multiply(DiscountConstants.VIP_DISCOUNT_RATE).negate();
        return List.of(new AppliedRule(
            DiscountConstants.RULE_G_ID,
            DiscountConstants.RULE_G_DESCRIPTION,
            discountAmount
        ));
    }
}
