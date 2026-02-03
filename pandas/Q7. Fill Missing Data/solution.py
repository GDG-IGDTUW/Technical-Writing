"""
Q7: Fill Missing Data

Problem Statement

Given a Pandas DataFrame products with the following columns:

name (object)

quantity (int)

price (int)

Some values in the quantity column are missing (None / NaN).

Task

Fill the missing values in the quantity column with 0 and return the updated DataFrame. 

They are extensively used for data analysis, and knowing how to create and manipulate them, such as handling missing values, is a common interview question.

Solution Approach

Pandas provides the fillna() method to replace missing values efficiently.

Explanation:

fillna(0) replaces all None / NaN values with 0

Only the quantity column is modified

The updated DataFrame is returned as required

Additional Notes :

This solution modifies only the quantity column

Time complexity: O(n)

Space complexity: O(1) (in-place operation)



"""

import pandas as pd

def fillMissingValues(products: pd.DataFrame) -> pd.DataFrame:
    products["quantity"] = products["quantity"].fillna(0)
    return products

    
