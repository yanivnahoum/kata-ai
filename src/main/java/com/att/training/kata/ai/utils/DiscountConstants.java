package com.att.training.kata.ai.utils;

import java.math.BigDecimal;

public final class DiscountConstants {
    public static final BigDecimal ZERO = BigDecimal.ZERO;
    public static final BigDecimal CART_TOTAL_THRESHOLD = new BigDecimal("300");
    public static final BigDecimal FREE_SHIPPING_THRESHOLD = new BigDecimal("1000");
    public static final BigDecimal CART_DISCOUNT_RATE = new BigDecimal("0.10");
    public static final BigDecimal VIP_DISCOUNT_RATE = new BigDecimal("0.05");
    public static final BigDecimal FREE_SHIPPING_DISCOUNT = new BigDecimal("50");

    public static final String RULE_A_ID = "A";
    public static final String RULE_F_ID = "F";
    public static final String RULE_G_ID = "G";

    public static final String RULE_A_DESCRIPTION = "10% cart discount (>300)";
    public static final String RULE_F_DESCRIPTION = "Free shipping (>1000)";
    public static final String RULE_G_DESCRIPTION = "VIP customer discount (5%)";

    private DiscountConstants() {
        throw new UnsupportedOperationException("Utility class");
    }
}
