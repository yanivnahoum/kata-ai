# Research & Decisions

## Technology Choice: Java 25 & Maven
- Decision: Use Java 25 features (Records, Pattern Matching, Sealed Types) built with Maven.
- Rationale: Project constitution mandates Java 25 and modern language features along with a Maven build system ensuring immutability and concise business logic.
- Alternatives considered: Older Java versions (rejected by Constitution).

## Domain Implementation: Discount Rule Execution
- Decision: Implement rules using a functional approach (e.g., `Function<Cart, Optional<AppliedRule>>`) or Strategy Pattern utilizing sealed functional interfaces.
- Rationale: The specification states "all discount rules apply simultaneously" and "functional purity". A functional pipeline allows evaluating all rules against the immutable Cart, collecting the generated AppliedRule records, and reducing the total.
- Alternatives considered: Imperative modification of cart state (rejected due to immutability/purity constraints).

## Arithmetic Precision
- Decision: Use `java.math.BigDecimal` for all monetary calculations.
- Rationale: Standard practice in financial applications to avoid double-precision floating-point inaccuracies.
- Alternatives considered: `double` (rejected due to precision loss).
