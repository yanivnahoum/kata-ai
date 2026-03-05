# Data Model

## CartItem

- identifier: String
- name: String
- unitPrice: BigDecimal
- quantity: int
- category: CategoryEnum (BOOK, ELECTRONICS, FOOD, OTHER)

## Cart

- items: List<CartItem> 
- customerId: String

## AppliedRule

- triggerIdentifier: String (e.g., "Rule A")
- description: String
- discountAmount: BigDecimal

## DiscountResult

- originalTotal: BigDecimal
- finalTotal: BigDecimal
- appliedRules: List<AppliedRule>
