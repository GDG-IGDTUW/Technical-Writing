## Approach

We need to identify visits that **do not appear** in the `Transactions` table.

### Steps

1. Perform a `LEFT JOIN` from `Visits` to `Transactions` using `visit_id`
2. Filter rows where `transaction_id` is `NULL`
3. Group the result by `customer_id`
4. Count the number of visits without transactions per customer

---

## SQL Solution

```sql
SELECT
    v.customer_id,
    COUNT(*) AS count_no_trans
FROM Visits v
LEFT JOIN Transactions t
    ON v.visit_id = t.visit_id
WHERE t.transaction_id IS NULL
GROUP BY v.customer_id;
```

### Explanation

- LEFT JOIN ensures all visits are included

- NULL transactions indicate no purchase was made

- Grouping by customer_id allows counting per customer

### Complexity Analysis

- Time Complexity: O(N)

- Space Complexity: O(1)
