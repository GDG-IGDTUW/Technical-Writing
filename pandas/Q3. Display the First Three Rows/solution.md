## Intuition

In pandas, the `.head(n)` function is used to return the first `n` rows of a DataFrame.  

Since we are asked to display the **first 3 rows**, we simply use:

.head(3)

This is efficient because:
- It directly retrieves only the required rows.
- It avoids unnecessary processing of the entire dataset.
- It is the standard and most readable approach in pandas for previewing data.

---

## Solution

```python
import pandas as pd

def display_first_three_rows(employees: pd.DataFrame) -> pd.DataFrame:
    return employees.head(3)
