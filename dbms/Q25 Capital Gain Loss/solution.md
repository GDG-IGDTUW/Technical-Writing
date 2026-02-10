## Key Observations

- A stock can have multiple buy and sell operations.
- The order of operations does **not** matter for this problem.
- We only need:
  - Sum of prices where `operation = 'Sell'`
  - Sum of prices where `operation = 'Buy'`
- Final answer is their difference, grouped by `stock_name`.

---

## Intuition

This is a **grouping and conditional aggregation** problem.

We can:
- Group rows by `stock_name`
- Treat:
  - `Sell` prices as **positive**
  - `Buy` prices as **negative**
- Sum everything together

This avoids needing separate subqueries.

---

## SQL Strategy

Use a `CASE` expression inside `SUM`:
- Add price when operation is `Sell`
- Subtract price when operation is `Buy`

Then group by `stock_name`.

---

## SQL Solution

```sql
SELECT
    stock_name,
    SUM(
        CASE
            WHEN operation = 'Sell' THEN price
            ELSE -price
        END
    ) AS capital_gain_loss
FROM Stocks
GROUP BY stock_name;
```
---

### Explanation of the Query

- CASE converts each row into a signed value:
Sell → +price and Buy → -price

- SUM(...) aggregates total gain/loss per stock

- GROUP BY stock_name ensures one row per stock

---

### Time and Space Complexity

- Time Complexity: O(N)
(single scan of the table)

- Space Complexity: O(1)
(ignoring output size)
