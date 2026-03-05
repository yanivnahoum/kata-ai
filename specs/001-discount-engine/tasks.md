# Implementation Tasks: Discount Engine

## Phase 1: Setup
- [X] T001 Set Java 25 compiler configuration and verify JUnit 5 / AssertJ dependencies in `pom.xml`

## Phase 2: Foundational
- [X] T002 [P] Create `Category` enum in `src/main/java/com/att/training/kata/ai/models/Category.java`
- [X] T003 [P] Create immutable `CartItem` record in `src/main/java/com/att/training/kata/ai/models/CartItem.java`
- [X] T004 [P] Create immutable `Cart` record in `src/main/java/com/att/training/kata/ai/models/Cart.java`
- [X] T005 [P] Create immutable `AppliedRule` record in `src/main/java/com/att/training/kata/ai/models/AppliedRule.java`
- [X] T006 [P] Create immutable `DiscountResult` record in `src/main/java/com/att/training/kata/ai/models/DiscountResult.java`
- [X] T007 [P] Define `DiscountEngine` interface according to contracts in `src/main/java/com/att/training/kata/ai/engine/DiscountEngine.java`
- [X] T008 [P] Define functional `DiscountRule` interface establishing rules input/output in `src/main/java/com/att/training/kata/ai/rules/DiscountRule.java`
- [X] T009 Create `DiscountConstants` utility class for thresholds and literal mapping in `src/main/java/com/att/training/kata/ai/utils/DiscountConstants.java`

## Phase 3: User Story 1 - Apply Total and Customer Based Discounts (P1)
**Goal**: Implement core pricing mechanics applying volumetric total thresholds and generalized customer status rules.
**Independent Test**: Supply varying carts >300 and >1000 in worth using VIP and Non-VIP users without any specific category items mapped.

- [X] T010 [US1] Create `TotalDiscountRuleTest` verifying Rules A and F in `src/test/java/com/att/training/kata/ai/rules/TotalDiscountRuleTest.java`
- [X] T011 [US1] Implement `TotalDiscountRule` functionality for Rules A and F in `src/main/java/com/att/training/kata/ai/rules/TotalDiscountRule.java`
- [X] T012 [P] [US1] Create `CustomerDiscountRuleTest` verifying Rule G in `src/test/java/com/att/training/kata/ai/rules/CustomerDiscountRuleTest.java`
- [X] T013 [P] [US1] Implement `CustomerDiscountRule` for VIP status in `src/main/java/com/att/training/kata/ai/rules/CustomerDiscountRule.java`
- [X] T014 [US1] Create `DefaultDiscountEngineTest` verifying orchestrated baseline rules in `src/test/java/com/att/training/kata/ai/engine/DefaultDiscountEngineTest.java`
- [X] T015 [US1] Implement `DefaultDiscountEngine` executing pipeline for tested rules in `src/main/java/com/att/training/kata/ai/engine/DefaultDiscountEngine.java`

## Phase 4: User Story 2 - Apply Category-specific Discounts (P2)
**Goal**: Trigger fixed and percentage deductions mapped specifically to combinations of sub-category volumes. (BOOKS, ELECTRONICS, FOOD).
**Independent Test**: Use isolated carts featuring only BOOK, ELECTRONICS, or FOOD items to verify that rules B, D, and E trigger precisely to specification thresholds.

- [ ] T016 [US2] Create `CategoryDiscountRuleTest` covering rules B, D, and E in `src/test/java/com/att/training/kata/ai/rules/CategoryDiscountRuleTest.java`
- [ ] T017 [US2] Implement `CategoryDiscountRule` handling specialized mapping for B, D, and E in `src/main/java/com/att/training/kata/ai/rules/CategoryDiscountRule.java`
- [ ] T018 [US2] Inject the `CategoryDiscountRule` into `DefaultDiscountEngine` in `src/main/java/com/att/training/kata/ai/engine/DefaultDiscountEngine.java`
- [ ] T019 [US2] Expand `DefaultDiscountEngineTest` integrating category-based discounting scenarios in `src/test/java/com/att/training/kata/ai/engine/DefaultDiscountEngineTest.java`

## Phase 5: User Story 3 - Apply Quantity Discounts & Overlap Guarantees (P3)
**Goal**: Enable individual bulk pricing rules and systematically constrain calculation accumulation from dropping totals below zero safely.
**Independent Test**: Verify by heavily discounting carts with numerous (5+) items alongside overlapping rules to ensure combined discounts function purely, clamping correctly to mathematically sound minimums without double dips.

- [ ] T020 [US3] Create `QuantityDiscountRuleTest` validating Rule C functionality in `src/test/java/com/att/training/kata/ai/rules/QuantityDiscountRuleTest.java`
- [ ] T021 [US3] Implement `QuantityDiscountRule` identifying and reducing the cheapest entity per Rule C constraint in `src/main/java/com/att/training/kata/ai/rules/QuantityDiscountRule.java`
- [ ] T022 [US3] Incorporate `QuantityDiscountRule` into `DefaultDiscountEngine` pipeline incorporating math clamp mechanisms to zero in `src/main/java/com/att/training/kata/ai/engine/DefaultDiscountEngine.java`
- [ ] T023 [US3] Enact comprehensive overlap limit and quantity boundary validation testing within `DefaultDiscountEngineTest` in `src/test/java/com/att/training/kata/ai/engine/DefaultDiscountEngineTest.java`

## Phase 6: Polish
- [ ] T024 Perform edge-case code review specifically addressing 0 total, 0 price values, and cart empty configurations via parameterized testing. Add to `src/test/java/com/att/training/kata/ai/engine/DefaultDiscountEngineTest.java`
- [ ] T025 Execute global cleanup, assuring all literal numbers sit properly modeled into `DiscountConstants` directly within `src/main/java/com/att/training/kata/ai/utils/DiscountConstants.java` 

---

## Dependencies
- Phase 1 must complete before Phase 2.
- Phase 2 (Foundational schemas) must block Phases 3+.
- Phase 3, 4, 5 are theoretically implementation independent provided the engine handles pipeline registration purely, however standard progression is logical.
- Polish strictly comes post-feature completion.

## Parallel Execution Examples
- After **Phase 1**, all Data Models (T002-T006) alongside the Engine Base interface (T007-T008) can be completed linearly as independent functions by separating contributors.
- Within **Phase 3**, `CustomerDiscountRule` implementation (T012-T013) can run precisely in tandem alongside `TotalDiscountRule` (T010-T011) as they are completely decoupled rule structures.

## Implementation Strategy
To uphold the constitution's `TDD Rules`, testing precedes implementation (Red-Green-Refactor). We begin strictly building the MVP (US1), achieving fully functional pure pipeline execution covering volume before escalating toward category complexity mapping and specific single-item alterations within subsequent stories.