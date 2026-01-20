# 🔄 Stage 4: Controlled TDD (25 min)

**Goal**: TDD pattern = YOU control Copilot

**For EACH rule (A-D)**:

```text
1. Add EXERCISE.md to the context window of copilot
2. Copilot Chat:
    2.1 Change to 'Agent' mode
    2.2 Choose this model: Gemini 3 Flash (Preview)
    2.3 "Suggest 4 Jest tests for Rule A"
    2.4 create ONLY the test file
3. Pick best 3 → PASTE IN tests/discountEngine.spec.ts
4. npm test → RED (good!)
5. Copilot Chat: "Implement minimum code in discountEngine.ts to pass THESE EXACT TESTS, the goal: npm test → GREEN"
6. REFACTOR the code using copilot to match your project conventions
7. repeat the process for Rule B-D
```

**Final step**:

```text
"Write integration test: all 4 rules apply together"
"Combine rules into calculateDiscounts()"
```
