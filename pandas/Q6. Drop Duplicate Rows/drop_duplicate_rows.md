## Drop Duplicate Rows (Pandas)

### Problem Statement
Given a pandas DataFrame, remove duplicate rows.

### Approach
Pandas provides the built-in `drop_duplicates()` method to remove duplicate rows efficiently.

### Solution
```python
import pandas as pd

def drop_duplicate_rows(df: pd.DataFrame) -> pd.DataFrame:
    return df.drop_duplicates()
```

### Example
```
data = {
    "id": [1, 1, 2, 3, 3],
    "name": ["A", "A", "B", "C", "C"]
}

df = pd.DataFrame(data)
result = drop_duplicate_rows(df)
print(result) 
```

### Output
```
   id name
0   1    A
2   2    B
3   3    C
```
### Key Notes
- drop_duplicates() removes duplicate rows by default.
- Use subset to remove duplicates based on specific columns.
- Use keep='first' or keep='last' to control which duplicate is retained.

### Interview Relevance
This operation is commonly used in:

- Data cleaning
- ETL pipelines
- Exploratory Data Analysis (EDA)