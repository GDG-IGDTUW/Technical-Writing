# 2887. Fill Missing Data

## Problem Statement 

Given a Pandas DataFrame products with the following columns:

Name (object)
Quantity (int)
Price (int)

Some values in the quantity column are missing (None / NaN).

## Task

Fill the missing values in the quantity column with 0 and return the updated DataFrame.

---

## Solution

Pandas provides the fillna() method to replace missing values efficiently.

## Additional Notes

This solution modifies only the quantity 

Time complexity: O(n)

Space complexity: O(1) (in-place operation)


### Python Implementation
 ```python  
import pandas as pd

def fillMissingValues(products: pd.DataFrame) -> pd.DataFrame:
    products["quantity"] = products["quantity"].fillna(0)
    return products
```

### Example Usage Full Code

```python
import pandas as pd
from solution import fillMissingValues

# Create sample DataFrame
data = {
    "name": ["Wristwatch", "WirelessEarbuds", "GolfClubs", "Printer"],
    "quantity": [None, None, 779, 849],
    "price": [135, 821, 9319, 3051]
}

products = pd.DataFrame(data)

print("Before filling missing values:")
print(products)

# Apply function
products = fillMissingValues(products)

print("\nAfter filling missing values:")
print(products)
```
<img width="1908" height="860" alt="image" src="https://github.com/user-attachments/assets/368dbba6-2e0b-4182-90f9-ffde059b995a" />
