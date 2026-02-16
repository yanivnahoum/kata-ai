## Coding Standards

- Use TypeScript with strict typing.
- Follow functional programming principles.
- Avoid magic numbers; use named constants instead.
- Write pure functions with clear input and output.
- Use descriptive variable and function names.
- Const variable should be inside a `*.const.ts` file
- Utils functions should be inside a `*.util.ts` file

## Testing

- Make sure to write unit tests for each discount type and edge cases.
- Prefer using `it.each` for parameterized tests.
- Mock data should be inside a `*.mock.ts` file
- Test files should be named as `*.test.ts` like the example: `discountEngine.test.ts`
- Achieve at least 90% code coverage.
- Use a consistent testing framework (e.g., Jest).
