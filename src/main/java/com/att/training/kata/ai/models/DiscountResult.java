package com.att.training.kata.ai.models;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public record DiscountResult(BigDecimal originalTotal, BigDecimal finalTotal, List<AppliedRule> appliedRules) {

    public DiscountResult {
        Objects.requireNonNull(originalTotal, "originalTotal must not be null");
        Objects.requireNonNull(finalTotal, "finalTotal must not be null");
        appliedRules = List.copyOf(Objects.requireNonNull(appliedRules, "appliedRules must not be null"));
    }
}
