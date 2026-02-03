# Delete Duplicate Emails

## Problem
**Platform:** LeetCode  
**Problem Link:** https://leetcode.com/problems/delete-duplicate-emails/

The goal is to delete all duplicate email entries from the `Person` table, keeping only the record with the smallest `id` for each email.

---

## Table Schema

```sql
Person(
    id INT,
    email VARCHAR
)
```

- id is the primary key.
- email may contain duplicate values.
---
## Approach

To remove duplicate emails while retaining the record with the minimum id, we can use a self join on the Person table:

- Join the table with itself using the same email.
- Compare IDs to identify duplicate rows.
- Delete the row with the greater id, keeping the smallest one.

---

## SQL Solution
```sql
DELETE t1 
FROM Person t1
JOIN Person t2 
ON t1.email = t2.email
AND t1.id > t2.id;
```
---
## Explanation

- t1 and t2 represent two instances of the same table.
- The join condition matches rows with the same email.
- t1.id > t2.id ensures only duplicate rows with higher IDs are deleted.
- The row with the smallest id for each email remains.
---
## Result

After executing the query:
- Each email appears only once.
- Duplicate entries are removed safely and efficiently.
---
## Key Concepts Used

- Self Join
- DELETE with JOIN
- Deduplication using primary keys
