# Human Traffic of Stadium

**Difficulty:** Hard  
**Tags:** SQL, Window Functions  

**Platform:** LeetCode  
**Problem:** Human Traffic of Stadium  

---

## Problem Statement

You are given a `Stadium` table with the following structure:

```text
Stadium
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| visit_date  | date    |
| people      | int     |
+-------------+---------+
```
Write an SQL query to find all rows that are part of a period where the number of people
was greater than or equal to 100 for at least three consecutive days.

## Acceptance Criteria

- Correct identification of consecutive days
- Filters only valid traffic sequences
- Maintains original ordering
- Uses window functions

## Approach

A row should be included if it is part of any sequence of three consecutive rows
where people >= 100.
A row can be:
- the first
- the middle
- or the last
row in such a sequence.
To detect this, we inspect neighboring rows using LAG and LEAD.

---
**SQL Solution (Using Window Functions)**
```sql
SELECT id, visit_date, people
FROM (
    SELECT *,
           LAG(people, 1) OVER (ORDER BY id) AS p1,
           LAG(people, 2) OVER (ORDER BY id) AS p2,
           LEAD(people, 1) OVER (ORDER BY id) AS n1,
           LEAD(people, 2) OVER (ORDER BY id) AS n2
    FROM Stadium
) t
WHERE people >= 100
AND (
       (p1 >= 100 AND p2 >= 100)   -- current row is last
    OR (p1 >= 100 AND n1 >= 100)   -- current row is middle
    OR (n1 >= 100 AND n2 >= 100)   -- current row is first
)
ORDER BY id;
```

**Explanation**
**Window Functions Used**
```sql
- LAG(people, 1)  -- previous row
- LAG(people, 2)  -- two rows before
- LEAD(people, 1) -- next row
- LEAD(people, 2) -- two rows after
```
These functions allow us to check neighboring days without joins.

**Valid Consecutive Patterns**

A row is valid if it satisfies any one of the following:
- Previous two days had people >= 100
- Previous and next day had people >= 100
- Next two days had people >= 100
This ensures inclusion of all rows belonging to valid 3-day periods.

**Filtering Only Relevant Rows**
```sql
WHERE people >= 100
```
Ensures rows below the threshold are never included.

**Maintaining Original Order**
```sql
ORDER BY id
```
Preserves the original ordering of records.

**Bonus: Gap-and-Island Technique (Concept)**

An alternative approach is the gap-and-island technique:
1. Filter rows where people >= 100
2. Assign row numbers
3. Group using:
id - ROW_NUMBER()
4. Count rows per group
5. Keep groups with count ≥ 3
While valid, the LAG/LEAD approach is more direct and easier to reason about.
