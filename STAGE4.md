# 🔄 Stage 4: Controlled TDD (25 min)

**Goal**: TDD pattern = YOU control Copilot

**For EACH rule (A-D)**:

```text
1. Copilot Chat: "Suggest 4 Jest tests for Rule A"
2. Pick best 3 → PASTE IN tests/discountEngine.spec.ts
3. npm test → RED (good!)
4. "Implement minimum code in discountEngine.ts to pass THESE EXACT TESTS, the goal: npm test → GREEN"
5. "Add 2 edge case tests for Rule B-D"
```

**Final step**:

```text
"Write integration test: all 7 rules apply together"
"Combine rules into calculateDiscounts()"
```

---
