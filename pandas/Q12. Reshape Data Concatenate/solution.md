
## Problem
Given two pandas DataFrames, df1 and df2, which have the same structure (same columns).

To do: Write a solution to concatenate these two DataFrames vertically into one table.

---

## Solution

Use the pd.concat() function to combine DataFrames.

### Python Implementation
```python
import pandas as pd

def concatenateTables(df1: pd.DataFrame, df2: pd.DataFrame) -> pd.DataFrame:
    return pd.concat([df1, df2])  # axis=0 is default, can omit
```

Explanation
- pd.concat([list]): Accepts a list of DataFrames to join.
- axis=0: Indicates that we are stacking the data vertically (adding rows), 
- as opposed to axis=1 which adds columns side-by-side.
