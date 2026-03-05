package com.att.training.kata.ai.rules;

import com.att.training.kata.ai.models.Cart;
import com.att.training.kata.ai.models.CartItem;
import com.att.training.kata.ai.models.Category;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TotalDiscountRuleTest {

    private final TotalDiscountRule rule = new TotalDiscountRule();

    @Test
    void shouldApplyRuleAWhenCartTotalIsGreaterThan300() {
        Cart cart = cartWithSingleItemPrice("350");

        var appliedRules = rule.apply(cart, new BigDecimal("350"));

        assertThat(appliedRules).hasSize(1);
        assertThat(appliedRules.getFirst().ruleId()).isEqualTo("A");
        assertThat(appliedRules.getFirst().discountAmount()).isEqualByComparingTo("-35.0");
    }

    @Test
    void shouldApplyRuleAAndRuleFWhenCartTotalIsGreaterThan1000() {
        Cart cart = cartWithSingleItemPrice("1200");

        var appliedRules = rule.apply(cart, new BigDecimal("1200"));

        assertThat(appliedRules).hasSize(2);
        assertThat(appliedRules).extracting(ruleResult -> ruleResult.ruleId())
            .containsExactlyInAnyOrder("A", "F");
        assertThat(appliedRules.stream().filter(item -> item.ruleId().equals("A")).findFirst().orElseThrow()
            .discountAmount()).isEqualByComparingTo("-120");
        assertThat(appliedRules.stream().filter(item -> item.ruleId().equals("F")).findFirst().orElseThrow()
            .discountAmount()).isEqualByComparingTo("-50");
    }

    @Test
    void shouldNotApplyRulesWhenCartTotalIsAtOrBelow300() {
        Cart cart = cartWithSingleItemPrice("300");

        var appliedRules = rule.apply(cart, new BigDecimal("300"));

        assertThat(appliedRules).isEmpty();
    }

    private static Cart cartWithSingleItemPrice(String price) {
        return new Cart(
            "customer-1",
            List.of(new CartItem("item-1", "Item 1", new BigDecimal(price), 1, Category.OTHER))
        );
    }
}
