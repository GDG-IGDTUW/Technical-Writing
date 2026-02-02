## Department Highest Salary

## Problem Statement

You are given two tables:

### Employee
| Column        | Description |
|--------------|------------|
| id           | Employee ID |
| name         | Employee name |
| salary       | Employee salary |
| departmentId | ID of the employee's department |

### Department
| Column | Description |
|--------|------------|
| id     | Department ID |
| name   | Department name |

### Goal

For **each department**, find the **employee(s) with the highest salary** and return:

- Department name
- Employee name
- Salary

---

## Approach

There are **three main Pandas steps**:

1. **Group employees by department**
2. **Find the maximum salary per department**
3. **Filter employees who earn that maximum salary**
4. **Join with Department table to get department names**

---

## Step-by-Step Explanation

### 1️. Group by departmentId and find max salary

```python
max_salary = employee.groupby("departmentId")["salary"].max().reset_index()
```
- groupby("departmentId") → groups employees by department

- ["salary"].max() → finds highest salary in each group

- reset_index() → converts the result back to a DataFrame

### 2. Merge with original Employee table
```
emp_max = employee.merge(
    max_salary,
    on=["departmentId", "salary"],
    how="inner"
)
```

### 3. Join with Department table
```
result = emp_max.merge(
    department,
    left_on="departmentId",
    right_on="id",
    how="inner"
)
```

This adds the department name to the result.

### 4. Select final columns
```
result = result[["name_y", "name_x", "salary"]]
result.columns = ["Department", "Employee", "Salary"]
```
## Final code

```
import pandas as pd

def department_highest_salary(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
    # Step 1: Find max salary per department
    max_salary = employee.groupby("departmentId")["salary"].max().reset_index()
    
    # Step 2: Keep employees with max salary in each department
    emp_max = employee.merge(
        max_salary,
        on=["departmentId", "salary"],
        how="inner"
    )
    
    # Step 3: Join with department table
    result = emp_max.merge(
        department,
        left_on="departmentId",
        right_on="id",
        how="inner"
    )
    
    # Step 4: Select and rename columns
    result = result[["name_y", "name_x", "salary"]]
    result.columns = ["Department", "Employee", "Salary"]
    
    return result
```