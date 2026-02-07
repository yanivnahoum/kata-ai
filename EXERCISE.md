```markdown
# Copilot Mastery Kata: Discount Engine

**Duration**: 90 minutes  
**Your Mission**: Learn to control GitHub Copilot instead of being controlled by it.

## The Challenge

Build a **Discount Engine** that calculates final cart price + applied discount rules.

### Input Cart Example
```json
{
  "customerId": "user123",
  "items": [
    {"id": "book1", "name": "TypeScript Guide", "unitPrice": 120, "quantity": 2, "category": "BOOK"},
    {"id": "laptop", "name": "MacBook", "unitPrice": 4000, "quantity": 1, "category": "ELECTRONICS"}
  ]
}
```

### Expected Output
```json
{
  "originalTotal": 4240,
  "finalTotal": 3806,
  "appliedRules": [
    {"ruleId": "A", "description": "10% cart discount (>300)", "amount": -424},
    {"ruleId": "B", "description": "BOOK bundle discount (3+ books)", "amount": -15}
  ]
}
```

## Business Rules (IMPLEMENT EXACTLY)

**Rule A**: Cart total > 300 → 10% discount on entire cart  
**Rule B**: ≥3 BOOK items (total quantity) → 15₪ fixed discount  
**Rule C**: >5 items total → 50% off on cheapest item  

**Requirements**:
- Rules apply **simultaneously** 
- `finalTotal >= 0` (never negative)
- Return **all applied rules** with descriptions
- Pure functions only

## Types
```typescript
export type CartItem = {
  id: string; name: string; unitPrice: number; quantity: number; 
  category?: "BOOK" | "ELECTRONICS" | "FOOD";
};

export type Cart = { customerId: string; items: CartItem[] };

export type AppliedRule = { ruleId: string; description: string; amount: number };

export type DiscountResult = {
  originalTotal: number;
  finalTotal: number;
  appliedRules: AppliedRule[];
};
```

## Your Task

**Implement** `calculateDiscounts(cart: Cart): DiscountResult` in `src/discountEngine.ts`
