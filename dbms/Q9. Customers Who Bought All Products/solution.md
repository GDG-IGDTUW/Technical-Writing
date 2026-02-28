## Goal

Find the `customer_id` of customers who bought **all products** in the `Product` table.

---

## Approach

A customer qualifies only if:

Number of **distinct products purchased by customer**  
=  
Total number of products available

So we:

1. Count total products from `Product`
2. Group purchases by customer
3. Keep only those whose distinct purchases match total products

---

## SQL Solution

```sql
SELECT customer_id
FROM Customer
GROUP BY customer_id
HAVING COUNT(DISTINCT product_key) = (
    SELECT COUNT(*) FROM Product
);
```

---

### Explanation

- GROUP BY customer_id → evaluates each customer separately

- COUNT(DISTINCT product_key) → removes duplicate purchases

- Subquery → gets total number of products

- HAVING → filters customers who bought all products

---

### Complexity

- Time: O(N)

- Space: O(1)
