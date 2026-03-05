# Quickstart: Discount Engine

## Overview
This is a pure Java calculation library modeling a shopping cart discount engine, built with Java 25 and Maven.

## Setup
1. Build the project:
   ```bash
   ./mvnw clean verify
   ```
2. Run the tests:
   ```bash
   ./mvnw test
   ```

## Example Usage
```java
// Create items
CartItem item = new CartItem("p1", "Book", new BigDecimal("15.00"), 3, Category.BOOK);

// Create cart
Cart cart = new Cart("vip-123", List.of(item));

// Calculate discounts
DiscountEngine engine = new DefaultDiscountEngine();
DiscountResult result = engine.calculateDiscount(cart);

System.out.println("Original: " + result.originalTotal());
System.out.println("Final: " + result.finalTotal());
for (AppliedRule rule : result.appliedRules()) {
    System.out.println("- " + rule.description() + " : " + rule.discountAmount());
}
```
