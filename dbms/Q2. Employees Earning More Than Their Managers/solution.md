# Employees Earning More Than Their Managers

## Approach

Each employee record contains a `managerId` that refers to another row in the same table.
To compare employee salaries with their managers, we join the table with itself.

## SQL Explanation

- Join `Employee` as `e` (employee) with `Employee` as `m` (manager)
- Match `e.managerId = m.id`
- Filter rows where `e.salary > m.salary`
- Return the employee name

## SQL Code

```sql
SELECT e.name AS Employee
FROM Employee e
JOIN Employee m
  ON e.managerId = m.id
WHERE e.salary > m.salary;
