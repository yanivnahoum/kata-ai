# Feature Specification: Discount Engine

**Feature Branch**: `001-discount-engine`  
**Created**: 2026-03-05  
**Status**: Draft  
**Input**: User description: "Create a Discount Engine that calculates final cart price + applied discount rules."

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Apply Total and Customer Based Discounts (Priority: P1)

As a shopper, I want the system to automatically apply discounts based on my total shopping cart value and my customer status, so that I receive my entitled savings. 

**Why this priority**: Essential to the core pricing model. Volume-based and customer-status discounts typically have the largest impact and are heavily marketed.

**Independent Test**: Can be independently tested by checking carts that exceed specific total thresholds or belong to a VIP user without any specific category items.

**Acceptance Scenarios**:

1. **Given** a standard customer with a cart total over 300, **When** they checkout, **Then** a 10% discount on the entire cart is applied (Rule A).
2. **Given** a customer whose ID starts with "vip", **When** they checkout with any items, **Then** an additional 5% discount on the entire cart is applied (Rule G).
3. **Given** a cart total over 1000, **When** they checkout, **Then** a 50 deduction for free shipping is applied (Rule F).
4. **Given** a standard customer with a cart below 300, **When** they checkout, **Then** no cart-total or VIP discounts are applied.

---

### User Story 2 - Apply Category-specific Discounts (Priority: P2)

As a shopper buying specific types of goods, I want category-based discounts to automatically trigger, so that I can take advantage of category sales.

**Why this priority**: Focuses on the merchandising rules related to categories which are vital but secondary to global discounts.

**Independent Test**: Can be tested independently by submitting carts containing only items from specific categories (BOOK, ELECTRONICS, FOOD) and validating only those discounts trigger.

**Acceptance Scenarios**:

1. **Given** a cart with 3 or more BOOK items, **When** checking out, **Then** a 15 fixed discount is applied (Rule B).
2. **Given** a cart with 2 or more ELECTRONICS items, **When** checking out, **Then** a 5% discount on the total price of electronics is applied (Rule D).
3. **Given** a cart where the total cost of FOOD items exceeds 100, **When** checking out, **Then** a 20 fixed discount is applied (Rule E).

---

### User Story 3 - Apply Quantity Discounts & Overlap Guarantees (Priority: P3)

As a shopper buying many items, I want bulk discounts applied correctly, and I want all eligible discounts from all rules to be applied simultaneously without the balance dropping below zero.

**Why this priority**: Important for edge rules and making sure the system correctly combines discounts while setting a floor price.

**Independent Test**: Can be tested by providing heavily discounted carts and large item quantities to ensure calculations compose.

**Acceptance Scenarios**:

1. **Given** a cart with more than 5 total items, **When** checking out, **Then** a 50% discount on the cheapest item is applied (Rule C).
2. **Given** a cart that qualifies for multiple rules (e.g. VIP with books and food), **When** checking out, **Then** all applicable rules apply simultaneously.
3. **Given** a heavily discounted cart where discounts exceed the cart's value, **When** checking out, **Then** the final total defaults to 0 and is never negative.

---

### Edge Cases

- What happens when a cart contains zero items? (Expected: Original total 0, final total 0, and no rules applied).
- How does the system handle an item with a price of 0?
- What happens if the sum of all flat deductions and percentage discounts exceeds the cart's original total? (System must cap the final total at 0).

## Requirements *(mandatory)*

### Functional Requirements

- **FR-001**: System MUST calculate the total price of all items in a cart based on quantity and unit price.
- **FR-002**: System MUST apply Rule A: Cart total > 300 -> 10% discount on entire cart.
- **FR-003**: System MUST apply Rule B: >=3 BOOK items (total quantity) -> 15 fixed discount.
- **FR-004**: System MUST apply Rule C: >5 items total -> 50% off on cheapest item.
- **FR-005**: System MUST apply Rule D: >=2 ELECTRONICS items -> 5% discount on ELECTRONICS total.
- **FR-006**: System MUST apply Rule E: FOOD category total > 100 -> 20 fixed discount.
- **FR-007**: System MUST apply Rule F: Cart total > 1000 -> Free shipping (deduct 50 shipping cost).
- **FR-008**: System MUST apply Rule G: Customer ID starts with "vip" -> Additional 5% discount on entire cart.
- **FR-009**: System MUST apply all eligible rules simultaneously.
- **FR-010**: System MUST ensure the final total price is never negative (minimum 0).
- **FR-011**: System MUST return the calculated original total, the final total, and a list of all applied rules containing descriptions and their negative monetary impact.

### Key Entities *(include if feature involves data)*

- **CartItem**: Product in the cart including an identifier, name, unit price, quantity, and optional category (BOOK, ELECTRONICS, FOOD).
- **Cart**: Represents the current shopping session, containing a list of `CartItem` elements and a customer identifier.
- **AppliedRule**: A single discount instance detailing the rule trigger identifier, human-readable description, and negative monetary amount applied.
- **DiscountResult**: The overall output containing the initial cart total, calculated final total, and the collection of `AppliedRule` records.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: System calculation response matches expected outputs for 100% of defined acceptance criteria test cases.
- **SC-002**: Final calculated total resolves in <10ms.
