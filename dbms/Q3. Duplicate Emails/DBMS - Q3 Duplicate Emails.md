## Approach

1. **Group the rows by email** using `GROUP BY`.  
2. **Count the number of occurrences** for each email.  
3. **Filter emails that appear more than once** using the `HAVING` clause.  

This ensures that only emails that occur multiple times (duplicates) are returned.

---

## SQL Solution

```sql
SELECT email
FROM Person
GROUP BY email
HAVING COUNT(*) > 1;
```
---
## Explanation

- GROUP BY email : Groups rows by each unique email.

- COUNT(*) > 1 in HAVING : Only keeps groups that have more than one row, i.e., duplicates.

- The result table lists all emails that appear more than once in the Person table.

---

## Complexity

- Time Complexity: O(n) where n is the number of rows in the table.

- Space Complexity: O(m) where m is the number of unique emails (for grouping).

## Key Points

- HAVING is used to filter groups after aggregation.

- GROUP BY + COUNT is a standard pattern for finding duplicates in SQL.

- This solution works efficiently even if the table has millions of rows.
