# Implementation Plan: Discount Engine

**Branch**: `001-discount-engine` | **Date**: 2026-03-05 | **Spec**: [spec.md](./spec.md)
**Input**: Feature specification from `/specs/001-discount-engine/spec.md`

**Note**: This template is filled in by the `/speckit.plan` command. See `.specify/templates/plan-template.md` for the execution workflow.

## Summary

Create a core Discount Engine to calculate final cart prices + applies discount rules. The implementation will use Java 25 modern features (Records, Pattern Matching, Sealed classes) and Maven, following a pure functional, immutable domain model with 100% TDD test coverage.

## Technical Context

**Language/Version**: Java 25
**Primary Dependencies**: None (Pure Java Core), JUnit 5, AssertJ
**Storage**: N/A
**Testing**: JUnit 5, AssertJ (100% TDD enforcement, >90% coverage)
**Target Platform**: JVM 25 / Maven Environment
**Project Type**: Calculation Library
**Performance Goals**: <10ms per final calculated total
**Constraints**: Business logic must be implemented as side-effect-free pure functions. Must use BigDecimal for monetary precision. No negative cart totals.
**Scale/Scope**: Apply up to 7 base rules (A-G) simultaneously against a shopping cart in memory.

## Constitution Check

*GATE: Must pass before Phase 0 research. Re-check after Phase 1 design.*

- [x] **I. Test-First Development**: TDD strictly enforced with JUnit 5/AssertJ.
- [x] **II. Modern Java & Immutability**: All domains modeled as immutable Records. Set to Java 25.
- [x] **III. Functional Purity**: Standardized pure inputs/outputs mapping `Cart` -> `DiscountResult`.
- [x] **IV. No Magic Numbers**: Constants configuration will be used for all specific values (e.g. 300, 10%).
- [x] **V. Simplicity**: Implemented strictly against given requirements. All rules run simultaneously and mapped to pure functions.
Gate Decision: **PASS**

## Project Structure

### Documentation (this feature)

```text
specs/001-discount-engine/
├── plan.md              # This file (/speckit.plan command output)
├── research.md          # Phase 0 output (/speckit.plan command)
├── data-model.md        # Phase 1 output (/speckit.plan command)
├── quickstart.md        # Phase 1 output (/speckit.plan command)
├── contracts/           # Phase 1 output (/speckit.plan command)
└── tasks.md             # Phase 2 output (/speckit.tasks command - NOT created by /speckit.plan)
```

### Source Code (repository root)

```text
src/
├── main/java/com/att/training/kata/ai/
│   ├── models/
│   │   ├── Cart.java
│   │   ├── CartItem.java
│   │   ├── Category.java
│   │   ├── AppliedRule.java
│   │   └── DiscountResult.java
│   ├── engine/
│   │   ├── DiscountEngine.java
│   │   └── DefaultDiscountEngine.java
│   ├── rules/
│   │   ├── DiscountRule.java
│   │   ├── TotalDiscountRule.java (Rule A, Rule F)
│   │   ├── CategoryDiscountRule.java (Rule B, Rule D, Rule E)
│   │   ├── QuantityDiscountRule.java (Rule C)
│   │   └── CustomerDiscountRule.java (Rule G)
│   └── utils/
│       └── DiscountConstants.java
└── test/java/com/att/training/kata/ai/
    ├── engine/
    │   └── DefaultDiscountEngineTest.java
    └── rules/
        ├── TotalDiscountRuleTest.java
        ├── CategoryDiscountRuleTest.java
        ├── QuantityDiscountRuleTest.java
        └── CustomerDiscountRuleTest.java
```

**Structure Decision**: Selected Option 1 (Single Project) as it perfectly aligns with the pure calculation library paradigm delineated in the project constraints.

## Complexity Tracking

> **Fill ONLY if Constitution Check has violations that must be justified** (N/A)

| Violation | Why Needed | Simpler Alternative Rejected Because |
|-----------|------------|-------------------------------------|
| [e.g., 4th project] | [current need] | [why 3 projects insufficient] |
| [e.g., Repository pattern] | [specific problem] | [why direct DB access insufficient] |
