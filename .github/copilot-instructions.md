# Discount Engine Kata

This project involves creating a Discount Engine that calculates discounts based on various criteria.

## Coding Standards

- Use Java 25 with modern language features (records, pattern matching, sealed types).
- Follow functional programming principles where appropriate.
- Avoid magic numbers; use named constants instead.
- Write pure functions with clear input and output.
- Use descriptive variable and method names.
- Constants should be in dedicated constant classes (e.g., `DiscountConstants.java`) if they need to be shared between
  classes, or in their owning class otherwise.
- Utility functions should be in utility classes with private constructors (e.g., `DiscountUtils.java`).
- Use immutable data structures and records where possible.
- Leverage Java 25 features like pattern matching, switch expressions, and text blocks.

## Testing

- Make sure to write unit tests for each discount type and edge cases.
- Prefer using `@ParameterizedTest` with `@MethodSource` or `@CsvSource` for parameterized tests.
- Mock data should be in dedicated test data classes or builder patterns.
- Test files should be named as `*Test.java` following the class and package names (e.g., `DiscountEngineTest.java`).
- Achieve at least 90% code coverage.
- Use JUnit 5 as the testing framework.
- Use AssertJ for fluent assertions where appropriate.
