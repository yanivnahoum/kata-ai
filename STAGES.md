
## 5 Stages - Follow EXACTLY

### 🚨 Stage 1: Wild Copilot (15 min)
**Goal**: See Copilot's default behavior (spoiler: it's not great)

1. Open Copilot Chat (`Ctrl+Shift+I`)
2. Type: `Build discount engine as described in EXERCISE.md`
3. Let Copilot generate **everything**
4. Run `npm test` → **Document what breaks**

**WRITE DOWN** (in comments):
- Missing tests?
- Wrong logic?
- Magic numbers?
- Poor structure?
- test without 'it.each'?
- const file

---

### ✅ Stage 2: Custom Instructions (20 min)
**Goal**: Fix Copilot with project rules

1. **Create** `.github/copilot-instructions.md`:
```markdown
# Discount Engine Rules

## Tech
- Node 18+, TypeScript 5+, Jest, CommonJS only
- Pure functions (<30 lines), explicit names

## Standards
- Write 3-5 Jest tests BEFORE each function
- No magic numbers → named constants
- Test happy path + 2 edge cases per rule
- Validate inputs, throw descriptive errors

## Rules A/B/C
- Implement exactly as specified in exercise.md
- Rules must be composable/testable separately
- Always return appliedRules array (exact format)
- finalTotal never negative
```

2. **Restart VS Code** (reloads instructions)
3. Run Plan Mode **again** → `npm test`
4. **COMPARE** Stage 1 vs Stage 2

---

### 📝 Stage 3: Master Prompt (25 min)
**Goal**: Write prompts that control Copilot

1. **Copilot Chat** → Write this **Master Prompt**:
```
PLAN discount engine implementation (NO CODE YET):

1. Create 3 pure functions: applyRuleA(), applyRuleB(), applyRuleC()
2. Each returns {amount: number, description: string} | null
3. calculateDiscounts() orchestrates all 3 rules
4. For EACH rule → suggest 4 Jest tests first

Tech: Node/TS/Jest/CommonJS, use src/types.ts
Output: Step-by-step plan only
```

2. **Review Copilot's plan** → Edit if needed
3. **Execute step-by-step**:
```
@workspace Implement Step 1 ONLY (Rule A + tests)
```

---

### 🔄 Stage 4: Controlled TDD (25 min)
**Goal**: TDD pattern = YOU control Copilot

**For EACH rule (A, B, C)**:

```
1. Copilot Chat: "Suggest 4 Jest tests for Rule A"
2. Pick best 3 → PASTE IN tests/discountEngine.spec.ts
3. npm test → RED (good!)
4. "Implement minimum code to pass THESE EXACT TESTS"
5. npm test → GREEN
6. "Add 2 edge case tests for Rule A"
```

**Final step**:
```
"Write integration test: all 3 rules apply together"
"Combine rules into calculateDiscounts()"
```

---

### ✨ Stage 5: Bonus Refactor (5 min)
```
@workspace Refactor calculateDiscounts to use reduce() instead of ifs
Keep all tests GREEN
```

## Run Tests

```bash
npm test          # All tests
npm test -- --coverage  # Check 90%+ coverage
```

## Success = ✅

```
[ ] All 3 rules work correctly
[ ] finalTotal never negative  
[ ] appliedRules lists everything
[ ] 90%+ test coverage
[ ] YOU controlled Copilot (not vice versa)
[ ] Can explain every line of code
```

## Anti-Patterns (DON'T DO THESE)

❌ `/plan Write complete solution`  
❌ Accept first suggestion blindly  
❌ No tests before code  
❌ Copy-paste without understanding  

---

## Expected Test File Structure

```typescript
// tests/discountEngine.spec.ts
describe('Rule A', () => {
  it('10% discount when total > 300', () => { /* ... */ });
  it('no discount when total <= 300', () => { /* ... */ });
});

describe('calculateDiscounts', () => {
  it('all rules combine correctly', () => { /* ... */ });
});
```

**Ready? Start with Stage 1!** 🏁
```

