## Approach

In **Pandas**, you can rename columns using the `.rename()` method.  

Steps:

1. Create a **mapping dictionary** where the keys are old column names and values are new column names.  
2. Use the `rename()` function with `columns=<mapping>` to rename the columns.  
3. (Optional) Use `inplace=True` if you want to modify the DataFrame in place.  

---

## Python Solution

```python
def renameColumns(students: pd.DataFrame) -> pd.DataFrame:
    # Mapping dictionary
    column_mapping = {
        'id': 'student_id',
        'first': 'first_name',
        'last': 'last_name',
        'age': 'age_in_years'
    }

    # Rename columns
    students.rename(columns=column_mapping, inplace=True)

    return students
```
---

## Explanation

- columns=column_mapping tells Pandas which columns to rename.

- inplace=True modifies the DataFrame directly; without it, .rename() returns a new DataFrame.

- After renaming, all column names match the expected output.
---

## Complexity

- Time Complexity: O(n) — Pandas needs to update column metadata.

- Space Complexity: O(1) — If using inplace=True, no extra memory is required.
