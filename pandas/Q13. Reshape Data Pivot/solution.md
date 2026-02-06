## Problem
Given a pandas DataFrame weather with columns: city, month, and temperature.

To write: a solution to pivot the data so that:
- The rows represent each `city`.
- The columns represent each `month`.
- The values in the cells are the `temperature`.

---

## Solution

Use the `.pivot()` method to reshape the DataFrame from a long format to a wide format.


### Python Implementation
```python
import pandas as pd
def pivotTable(weather: pd.DataFrame) -> pd.DataFrame:
    return weather.pivot(index='city', columns='month', values='temperature')
```

Explanation
- Index: The city column becomes the row labels.
- Columns: The month column provides the new headers.
- Values: The temperature data fills the intersection of the new rows and columns.