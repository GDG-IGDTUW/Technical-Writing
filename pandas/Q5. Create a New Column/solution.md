## Problem
You are given a pandas DataFrame `employees` with the following columns:

| Column Name | Type   |
|------------|--------|
| name       | object |
| salary     | int    |

A company plans to provide its employees with a bonus.

Write a solution to create a new column named `bonus` that contains the doubled values of the `salary` column.

## Solution

```python
import pandas as pd

def createBonusColumn(employees: pd.DataFrame) -> pd.DataFrame:
    employees["bonus"] = employees["salary"] * 2
    return employees
```
### Explanation

- Multiply the salary column by 2.
- Store the result in a new column called bonus.
- Return the updated DataFrame.
