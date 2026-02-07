# Copilot Mastery Kata: Discount Engine

**Duration**: 90 minutes  
**Your Mission**: Learn to control GitHub Copilot instead of being controlled by it.

## The Challenge

Build a **Discount Engine** that calculates final cart price + applied discount rules.

## Business Rules (IMPLEMENT EXACTLY)

**Rule A**: Cart total > 300 → 10% discount on entire cart  
**Rule B**: ≥3 BOOK items (total quantity) → 15₪ fixed discount  
**Rule C**: >5 items total → 50% off on cheapest item  
**Rule D**: ≥2 ELECTRONICS items → 5% discount on ELECTRONICS total

**Requirements**:

- Rules apply **simultaneously**
- `finalTotal >= 0` (never negative)
- Return **all applied rules** with descriptions
- Pure functions only

### Input Cart Example

```json
{
  "customerId": "vip123",
  "items": [
    {
      "id": "book1",
      "name": "TypeScript Guide",
      "unitPrice": 120,
      "quantity": 3,
      "category": "BOOK"
    },
    {
      "id": "laptop",
      "name": "MacBook",
      "unitPrice": 4000,
      "quantity": 2,
      "category": "ELECTRONICS"
    },
    {
      "id": "snack",
      "name": "Protein Bar",
      "unitPrice": 50,
      "quantity": 3,
      "category": "FOOD"
    }
  ]
}
```

### Expected Output

```json
{
  "originalTotal": 8510,
  "finalTotal": 7649.5,
  "appliedRules": [
    {
      "ruleId": "A",
      "description": "10% cart discount (>300)",
      "amount": -851
    },
    {
      "ruleId": "B",
      "description": "BOOK bundle discount (3+ books)",
      "amount": -15
    },
    {
      "ruleId": "C",
      "description": "50% off cheapest item (>5 items total)",
      "amount": -25
    },
    {
      "ruleId": "D",
      "description": "5% discount on ELECTRONICS total (≥2 ELECTRONICS items)",
      "amount": -400
    }
  ]
}
```

```typescript
export type CartItem = {
  id: string;
  name: string;
  unitPrice: number;
  quantity: number;
  category?: "BOOK" | "ELECTRONICS" | "FOOD";
};

export type Cart = { customerId: string; items: CartItem[] };

export type AppliedRule = {
  ruleId: string;
  description: string;
  amount: number;
};

export type DiscountResult = {
  originalTotal: number;
  finalTotal: number;
  appliedRules: AppliedRule[];
};
```

## Your Task

**Implement** `calculateDiscounts(cart: Cart): DiscountResult` in `src/discountEngine.ts`
