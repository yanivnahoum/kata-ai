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
**Rule E**: FOOD category total > 100 → 20₪ fixed discount  
**Rule F**: Cart total > 1000 → Free shipping (deduct 50₪ shipping cost)  
**Rule G**: Customer ID starts with "vip" → Additional 5% discount on entire cart

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
      "name": "AI for Dummies",
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
  "finalTotal": 6723.5,
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
    },
    {
      "ruleId": "E",
      "description": "FOOD category discount (>100)",
      "amount": -20
    },
    {
      "ruleId": "F",
      "description": "Free shipping (>1000)",
      "amount": -50
    },
    {
      "ruleId": "G",
      "description": "VIP customer discount (5%)",
      "amount": -425.5
    }
  ]
}
```

### Data Structures

```
Structure CartItem {
  id: String
  name: String
  unitPrice: Number (decimal)
  quantity: Number (integer)
  category: Enum (BOOK | ELECTRONICS | FOOD) [optional]
}

Structure Cart {
  customerId: String
  items: List<CartItem>
}

Structure AppliedRule {
  ruleId: String
  description: String
  amount: Number (decimal, negative for discounts)
}

Structure DiscountResult {
  originalTotal: Number (decimal)
  finalTotal: Number (decimal)
  appliedRules: List<AppliedRule>
}
```

## Your Task

**Implement** the discount calculation logic that takes a Cart and returns a DiscountResult.

**Method signature**: `calculateDiscounts(cart: Cart) → DiscountResult`
