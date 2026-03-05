package com.att.training.kata.ai.rules;

import com.att.training.kata.ai.models.Cart;
import com.att.training.kata.ai.models.CartItem;
import com.att.training.kata.ai.models.Category;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerDiscountRuleTest {

    private final CustomerDiscountRule rule = new CustomerDiscountRule();

    @ParameterizedTest
    @MethodSource("vipCustomerIds")
    void shouldApplyRuleGForVipCustomers(String customerId) {
        Cart cart = cartWithCustomer(customerId);

        var appliedRules = rule.apply(cart, new BigDecimal("200"));

        assertThat(appliedRules).hasSize(1);
        assertThat(appliedRules.getFirst().ruleId()).isEqualTo("G");
        assertThat(appliedRules.getFirst().discountAmount()).isEqualByComparingTo("-10.00");
    }

    @ParameterizedTest
    @MethodSource("standardCustomerIds")
    void shouldNotApplyRuleGForStandardCustomers(String customerId) {
        Cart cart = cartWithCustomer(customerId);

        var appliedRules = rule.apply(cart, new BigDecimal("200"));

        assertThat(appliedRules).isEmpty();
    }

    private static Stream<Arguments> vipCustomerIds() {
        return Stream.of(
            Arguments.of("vip123"),
            Arguments.of("VIP-001"),
            Arguments.of("Vip-Alpha")
        );
    }

    private static Stream<Arguments> standardCustomerIds() {
        return Stream.of(
            Arguments.of("customer-1"),
            Arguments.of("gold-vip"),
            Arguments.of("")
        );
    }

    private static Cart cartWithCustomer(String customerId) {
        return new Cart(
            customerId,
            List.of(new CartItem("item-1", "Item 1", new BigDecimal("200"), 1, Category.OTHER))
        );
    }
}
