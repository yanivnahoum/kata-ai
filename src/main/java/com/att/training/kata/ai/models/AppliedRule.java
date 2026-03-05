package com.att.training.kata.ai.models;

import java.math.BigDecimal;
import java.util.Objects;

public record AppliedRule(String ruleId, String description, BigDecimal discountAmount) {

    public AppliedRule {
        Objects.requireNonNull(ruleId, "ruleId must not be null");
        Objects.requireNonNull(description, "description must not be null");
        Objects.requireNonNull(discountAmount, "discountAmount must not be null");
        if (discountAmount.signum() > 0) {
            throw new IllegalArgumentException("discountAmount must be <= 0");
        }
    }
}
