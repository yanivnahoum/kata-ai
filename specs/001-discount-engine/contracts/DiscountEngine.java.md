# Contracts

## Discount Engine Service

The primary interface exposed is for the `DiscountEngine`.

```java
public interface DiscountEngine {
    DiscountResult calculateDiscount(Cart cart);
}
```
