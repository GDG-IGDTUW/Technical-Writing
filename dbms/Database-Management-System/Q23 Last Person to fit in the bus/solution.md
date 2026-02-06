## Solution Approach

1. **Order the people by `turn`** since boarding happens sequentially.  
2. **Calculate the cumulative weight** as each person boards.  
3. **Select the last person whose cumulative weight ≤ 1000 kg**.  

This can be efficiently done using **window functions** in SQL.

---

## SQL Solution

```sql
WITH CumulativeWeight AS (
    SELECT 
        person_name,
        SUM(weight) OVER (ORDER BY turn) AS total_weight
    FROM Queue
)
SELECT person_name
FROM CumulativeWeight
WHERE total_weight <= 1000
ORDER BY total_weight DESC
LIMIT 1;
```

## Explanation:

- SUM(weight) OVER (ORDER BY turn) calculates the running total of weight as people board.

- Filter with total_weight <= 1000 to ensure the weight limit is not exceeded.

- ORDER BY total_weight DESC LIMIT 1 ensures we get the last person who could board.
