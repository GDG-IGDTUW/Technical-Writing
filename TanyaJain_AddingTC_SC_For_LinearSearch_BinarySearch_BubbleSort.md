# Algorithm Complexity Analysis
---

## Overview
This document provides a detailed analysis of the approaches, time and space complexities of common algorithms, including Linear Search, Binary Search, and Bubble Sort. Each algorithm is explained with its best, average, and worst-case scenarios.
---

### 1. LINEAR SEARCH
    Linear Search is a simple searching algorithm that checks each element in a list sequentially.

APPROACH:
    1. Iterte in the array.
        - For each element, check if it is equal to the target element or not.
        - If it is equal return true.
        - Else, continue moving forward.

    2. If we reached the end of array, implies that array does not contain the target element.

### 2. BINARY SEARCH
    Binary Search is an efficient searching algorithm that works on sorted arrays by dividing the search space in half.

APPROACH:
    1. Initialize two variables start and end pointing to 0 and (n - 1)th index, where n is the size of array and 0-based indexing is followed.

    2. Iterate till start is less than or equal to end:
        - Calculate mid = start + (end - start)/2.

        - Check if arr[mid] is equal to target. If it is, return mid as this is the target element we're finding.

        - Else
            - If arr[mid] is less than target, implies target is on right side of mid, so update start to mid + 1.

            - Otherwise, it implies that target is on left side. So, update end to mid - 1.

    3. If we exit the loop, implies there is no target element in array, so we can return -1 which indicates target element is not present.

### 3. BUBBLE SORT
    Bubble Sort is a simple sorting algorithm that repeatedly swaps adjacent elements if they are in the wrong order.

APPROACH:
    1. Start from the first element and compare it with the next one.

    2. If the first element is greater than the second, swap them.

    3. Move to the next pair and repeat step 2.

    4. Continue until the last element.

    5. Repeat the above steps for the remaining unsorted elements.

    6. The largest element moves to its correct position in each iteration.

    7. Stop when no swaps are needed.

### Table explaning the complexitites

| Algorithm     | Approach   | Best Case Time | Average Case Time | Worst Case Time | Space Complexity |
|--------------|-----------|----------------|--------------------|-----------------|------------------|
| **Linear Search** | Iterative  | O(1)          | O(n)              | O(n)            | O(1)             |
|              | Recursive  | O(1)          | O(n)              | O(n)            | O(n) (due to recursion stack) |
| **Binary Search** | Iterative  | O(1)          | O(log n)          | O(log n)        | O(1)             |
|              | Recursive  | O(1)          | O(log n)          | O(log n)        | O(log n) (due to recursion stack) |
| **Bubble Sort** | Iterative  | O(n)          | O(n²)             | O(n²)           | O(1)             |
|               | Recursive  | O(n)          | O(n²)             | O(n²)           | O(n) (due to recursion stack) |


## Explanation:
1. Linear Search
- Best case: O(1) (element found at the start).
- Worst case: O(n) (element found at the end or not found).
- Recursive space complexity: O(n) due to function call stack.

2. Binary Search
- Best case: O(1) (middle element is the target).
- Worst case: O(log n) (keep dividing search space).
- Recursive space complexity: O(log n) (recursion stack depth).

3. Bubble Sort
- Best case: O(n) (already sorted array).
- Worst case: O(n²) (comparing every pair).
- Recursive space complexity: O(n) (function calls).