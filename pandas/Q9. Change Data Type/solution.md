## Problem
You are given a pandas DataFrame `students` with the following columns:
- student_id (int)
- name (object)
- age (int)
- grade (float)

To do: correct the errors in the `grade` column by converting it to an integer.

---

## Solution

We can use the .astype() method to cast a pandas Series to a specific data type.

### Python Implementation
```python
import pandas as pd

def changeDatatype(students: pd.DataFrame) -> pd.DataFrame:
    # Convert the 'grade' column to integer type
    students['grade'] = students['grade'].astype(int)
    return students
```

Explanation
- Selection: We target the specific column using students['grade'].

- Conversion: We apply .astype(int) to convert floating-point values (e.g., 90.0) to integers (e.g., 90).

- Assignment: The result is assigned back to the column to update the DataFrame.
