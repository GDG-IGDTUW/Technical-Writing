"""
Q1: Create a DataFrame from a List

Description:
This script demonstrates how to create a Pandas DataFrame from a Python list of lists.
DataFrames are 2-dimensional labeled data structures in Pandas, similar to Excel tables.

They are widely used in data analysis, and understanding how to create one from different sources
is a common interview question.

Interview Tip:
- Lists of lists can be converted into DataFrames with custom column names.
- Always label your columns clearly to make the data readable.
- Printing the DataFrame helps visualize the dataset for analysis.
"""

import pandas as pd

# List of students and their scores
students = [
    ["Alice", 85],
    ["Bob", 92],
    ["Charlie", 78],
    ["David", 90]
]

# Create DataFrame from list of lists with column names
df = pd.DataFrame(students, columns=['Name', 'Score'])

# Display the DataFrame
print(df)

"""
Expected Output:

      Name  Score
0    Alice     85
1      Bob     92
2  Charlie     78
3    David     90
"""
