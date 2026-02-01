### Problem: Median Employee Salary ###

**Platform**: LeetCode
**Problem Link**: https://leetcode.com/problems/median-employee-salary/

**Difficulty**: Hard
**Tags**: SQL, Window Functions

**Concept Reference:**
NTILE function explained here:
GeeksforGeeks – SQL NTILE Function

**Problem Statement**

Given an Employee table with the following structure:
```sql
Employee
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| id           | int     |
| company      | varchar |
| salary       | int     |
+--------------+---------+
```

Find the median salary for each company.
**Conditions**

- Must handle both odd and even number of employees
- Must use correct ranking logic
- No approximation (exact median only)

**Key Idea (How Median Works)**
Median Rules
- Odd number of employees → middle salary
- Even number of employees → average of the two middle salaries
To achieve this without approximation, we:
1. Sort salaries within each company
2. Assign row numbers
3. Count employees per company
4. Pick the middle row(s)

**MySQL Solution (Using Window Functions)**
**Final Query**
```sql
WITH ranked_salaries AS (
    SELECT
        company,
        salary,
        ROW_NUMBER() OVER (PARTITION BY company ORDER BY salary) AS rn,
        COUNT(*) OVER (PARTITION BY company) AS total_count
    FROM Employee
)
SELECT
    company,
    AVG(salary) AS median_salary
FROM ranked_salaries
WHERE
    rn IN (
        FLOOR((total_count + 1) / 2),
        FLOOR((total_count + 2) / 2)
    )
GROUP BY company;
```

**Why This Solution Works**

- Handles even and odd cases
- Uses precise row selection
- Avoids NTILE approximation issues
- Fully compliant with MySQL window functions
