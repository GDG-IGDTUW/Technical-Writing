### Problem

You are given a pandas DataFrame students with the following columns:

- Column Name	Type
- student_id	int
- name	object
- age	int

Write a solution to select the name and age of the student with student_id = 101.

Solution
```python
import pandas as pd


def selectData(students: pd.DataFrame) -> pd.DataFrame:
    return students.loc[students["student_id"] == 101, ["name", "age"]]
```

### Explanation
- Filter rows where student_id equals 101.
- Select only the name and age columns.
- Return the resulting DataFrame in the required format.
