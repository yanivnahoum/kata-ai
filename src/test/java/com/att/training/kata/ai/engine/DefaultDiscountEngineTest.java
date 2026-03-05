package com.att.training.kata.ai.engine;

import com.att.training.kata.ai.models.Cart;
import com.att.training.kata.ai.models.CartItem;
import com.att.training.kata.ai.models.Category;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultDiscountEngineTest {

    private final DefaultDiscountEngine engine = new DefaultDiscountEngine();

    @Test
    void shouldApplyTotalAndVipRulesSimultaneously() {
        Cart cart = new Cart(
            "vip-123",
            List.of(new CartItem("item-1", "Item 1", new BigDecimal("400"), 1, Category.OTHER))
        );

        var result = engine.calculateDiscount(cart);

        assertThat(result.originalTotal()).isEqualByComparingTo("400");
        assertThat(result.finalTotal()).isEqualByComparingTo("340");
        assertThat(result.appliedRules()).extracting(rule -> rule.ruleId())
            .containsExactlyInAnyOrder("A", "G");
    }

    @Test
    void shouldApplyRuleAAndRuleFAndRuleGWhenEligible() {
        Cart cart = new Cart(
            "vip-customer",
            List.of(new CartItem("item-1", "Item 1", new BigDecimal("1200"), 1, Category.OTHER))
        );

        var result = engine.calculateDiscount(cart);

        assertThat(result.originalTotal()).isEqualByComparingTo("1200");
        assertThat(result.finalTotal()).isEqualByComparingTo("970.0");
        assertThat(result.appliedRules()).extracting(rule -> rule.ruleId())
            .containsExactlyInAnyOrder("A", "F", "G");
    }

    @Test
    void shouldApplyNoRulesWhenCartIsBelowThresholdAndCustomerIsNotVip() {
        Cart cart = new Cart(
            "customer-1",
            List.of(new CartItem("item-1", "Item 1", new BigDecimal("200"), 1, Category.OTHER))
        );

        var result = engine.calculateDiscount(cart);

        assertThat(result.originalTotal()).isEqualByComparingTo("200");
        assertThat(result.finalTotal()).isEqualByComparingTo("200");
        assertThat(result.appliedRules()).isEmpty();
    }
}
