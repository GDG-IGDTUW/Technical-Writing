# LeetCode 176 — Second Highest Salary

## Problem
Table: `Employee`

| Column Name | Type |
|------------|------|
| id         | int  |
| salary     | int  |

Write a SQL query to report the **second highest salary** from the `Employee` table.  
If there is no second highest salary, return `null`.

---

## Approach
1. Find the **maximum salary** from the `Employee` table.
2. Exclude this maximum salary using a subquery.
3. From the remaining salaries, select the maximum value.
4. If no second highest salary exists, `MAX()` returns `NULL`.

---

## SQL Solution
```sql
SELECT MAX(salary) AS SecondHighestSalary
FROM Employee
WHERE salary < (SELECT MAX(salary) FROM Employee);
```
---
## Explanation
- The subquery (SELECT MAX(salary) FROM Employee) fetches the highest salary.
- The WHERE clause filters out employees having this highest salary.
- The outer MAX(salary) finds the largest salary among the remaining records.
- If the table contains only one distinct salary, the result will be NULL.

## Complexity
- Time Complexity: O(n)
- Space Complexity: O(1)
