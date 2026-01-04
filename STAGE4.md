# 🔄 Stage 4: Controlled TDD (25 min)

**Goal**: TDD pattern = YOU control Copilot

**For EACH rule (A-D)**:

```text
1. Add EXERCISE.md to the context window of copilot
2. Copilot Chat:
    2.1 Change to 'Plan' mode
    2.2 "Suggest 4 Jest tests for Rule A"
3. Pick best 3 → PASTE IN tests/discountEngine.spec.ts
4. npm test → RED (good!)
5. Copilot Chat: "Implement minimum code in discountEngine.ts to pass THESE EXACT TESTS, the goal: npm test → GREEN"
6. repeat the process for Rule B-D
```

**Final step**:

```text
"Write integration test: all 4 rules apply together"
"Combine rules into calculateDiscounts()"
```
