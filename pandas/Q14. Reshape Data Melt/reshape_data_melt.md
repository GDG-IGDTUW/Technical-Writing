# Issue 14: Reshape Data – Melt

## Problem Statement

You are given a DataFrame in **wide format** containing product sales data across multiple quarters.  
Reshape the DataFrame into **long format** using the `melt` operation.

---

### Input Example

```text
Input:
+-------------+-----------+-----------+-----------+-----------+
| product     | quarter_1 | quarter_2 | quarter_3 | quarter_4 |
+-------------+-----------+-----------+-----------+-----------+
| Umbrella    | 417       | 224       | 379       | 611       |
| SleepingBag | 800       | 936       | 93        | 875       |
+-------------+-----------+-----------+-----------+-----------+
```
### Output
```
+-------------+-----------+-------+
| product     | quarter   | sales |
+-------------+-----------+-------+
| Umbrella    | quarter_1 | 417   |
| SleepingBag | quarter_1 | 800   |
| Umbrella    | quarter_2 | 224   |
| SleepingBag | quarter_2 | 936   |
| Umbrella    | quarter_3 | 379   |
| SleepingBag | quarter_3 | 93    |
| Umbrella    | quarter_4 | 611   |
| SleepingBag | quarter_4 | 875   |
+-------------+-----------+-------+
```
## Pandas Solution
```
import pandas as pd

def meltTable(report: pd.DataFrame) -> pd.DataFrame:
    return report.melt(
        id_vars="product",
        var_name="quarter",
        value_name="sales"
    )
```

## What does melt() do?
- Converts a wide DataFrame into a long format

- Turns column names into row values

## Why is melt() used?
- Makes data tidy and analysis-friendly

- Required when multiple columns represent the same variable

## Code Explanation
- id_vars="product" keeps the product column unchanged

- var_name and value_name define the new column names for reshaped data

