package com.att.training.kata.ai.rules;

import com.att.training.kata.ai.models.AppliedRule;
import com.att.training.kata.ai.models.Cart;
import com.att.training.kata.ai.utils.DiscountConstants;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class TotalDiscountRule implements DiscountRule {

    @Override
    public List<AppliedRule> apply(Cart cart, BigDecimal originalTotal) {
        List<AppliedRule> appliedRules = new ArrayList<>();

        if (originalTotal.compareTo(DiscountConstants.CART_TOTAL_THRESHOLD) > 0) {
            BigDecimal discountAmount = originalTotal.multiply(DiscountConstants.CART_DISCOUNT_RATE).negate();
            appliedRules.add(new AppliedRule(
                DiscountConstants.RULE_A_ID,
                DiscountConstants.RULE_A_DESCRIPTION,
                discountAmount
            ));
        }

        if (originalTotal.compareTo(DiscountConstants.FREE_SHIPPING_THRESHOLD) > 0) {
            appliedRules.add(new AppliedRule(
                DiscountConstants.RULE_F_ID,
                DiscountConstants.RULE_F_DESCRIPTION,
                DiscountConstants.FREE_SHIPPING_DISCOUNT.negate()
            ));
        }

        return List.copyOf(appliedRules);
    }
}
