<!--
  Sync Impact Report
  ==================
  Version change: N/A → 1.0.0 (initial ratification)
  Modified principles: None (initial creation)
  Added sections:
    - Core Principles (5 principles: Test-First, Modern Java & Immutability,
      Functional Purity, No Magic Numbers, Simplicity)
    - Technology Constraints
    - Development Workflow
    - Governance
  Removed sections: None
  Templates requiring updates:
    - .specify/templates/plan-template.md ✅ no update needed (generic gates)
    - .specify/templates/spec-template.md ✅ no update needed (compatible)
    - .specify/templates/tasks-template.md ✅ no update needed (TDD aligned)
  Follow-up TODOs: None
-->

# Discount Engine Kata Constitution

## Core Principles

### I. Test-First Development (NON-NEGOTIABLE)

- TDD MUST be followed for every feature: write tests first, verify
  they fail, then implement the minimum code to pass.
- Red-Green-Refactor cycle is strictly enforced.
- Use JUnit 5 as the testing framework; use AssertJ for fluent
  assertions.
- Prefer `@ParameterizedTest` with `@MethodSource` or `@CsvSource`
  for parameterized tests.
- Test files MUST be named `*Test.java` matching the class and
  package under test (e.g., `DiscountEngineTest.java`).
- MUST achieve at least 90% code coverage.
- Mock data MUST reside in dedicated test data classes or use builder
  patterns.

### II. Modern Java & Immutability

- Use Java 25 with modern language features: records, pattern
  matching, sealed types, switch expressions, and text blocks.
- Use immutable data structures and records for all domain models.
- Leverage pattern matching and switch expressions to eliminate
  verbose conditional chains.

### III. Functional Purity

- Business logic MUST be implemented as pure functions with clear
  input and output.
- Follow functional programming principles where appropriate.
- Discount rules MUST be side-effect-free: given the same cart, they
  MUST always produce the same result.
- Utility functions MUST reside in utility classes with private
  constructors (e.g., `DiscountUtils.java`).

### IV. No Magic Numbers

- All numeric and string literals with domain meaning MUST be
  replaced with named constants.
- Constants shared across classes MUST reside in dedicated constant
  classes (e.g., `DiscountConstants.java`).
- Constants used only within a single class SHOULD be declared in
  that class.
- Use descriptive variable and method names throughout.

### V. Simplicity

- Start simple; apply YAGNI—do not implement features not explicitly
  required by the business rules.
- Write the minimum code to pass the current test.
- Avoid over-engineering; complexity MUST be justified.
- Each discount rule MUST be independently testable and
  understandable in isolation.

## Technology Constraints

- **Language**: Java 25 (LTS features + preview where appropriate)
- **Build**: Maven (use `./mvnw verify` to build and `./mvnw test`
  to run tests)
- **Testing**: JUnit 5 + AssertJ
- **Project type**: Single-module Maven project
- **Domain**: Discount Engine — pure calculation library, no I/O or
  persistence

## Development Workflow

- For each business rule (A through G), follow the TDD cycle:
  1. Write unit tests covering the rule and edge cases (RED).
  2. Verify tests fail.
  3. Implement minimum code to pass (GREEN).
  4. Refactor to meet coding standards (REFACTOR).
- After all individual rules pass, create integration tests that
  verify all rules work correctly together.
- All discount rules apply simultaneously to a cart.
- `finalTotal` MUST never be negative (floor at 0).
- Return all applied rules with descriptions.

## Governance

- This constitution supersedes all other ad-hoc practices for this
  project.
- Any amendment MUST be documented with a version bump, rationale,
  and migration notes.
- All code contributions MUST verify compliance with these
  principles before merging.
- Complexity beyond what the principles allow MUST be justified in
  writing.
- Runtime development guidance is captured in
  `.github/copilot-instructions.md`.

**Version**: 1.0.0 | **Ratified**: 2026-03-05 | **Last Amended**: 2026-03-05
