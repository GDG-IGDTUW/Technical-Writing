Common Algorithms and Their Complexities

This document lists various algorithms and their time/space complexities. Some complexities are missing - can you help fill them in?

1. Linear Search
Description: Sequentially checks each element in a list until a match is found or the end of list is reached.
- Best case: O(1) (element found at the start).
- Worst case: O(n) (element found at the end or not found).
- Recursive space complexity: O(n) due to function call stack.


2. Binary Search
Description: Repeatedly divides a sorted array in half, eliminating the half that cannot contain the target value.
- Best case: O(1) (middle element is the target).
- Worst case: O(log n) (keep dividing search space).
- Recursive space complexity: O(log n) (recursion stack depth).

3. Bubble Sort
Description: Repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order.
- Best case: O(n) (already sorted array).
- Worst case: O(n²) (comparing every pair).
- Recursive space complexity: O(n) (function calls).

**Table explaning the complexitites**

| Algorithm     | Approach   | Best Case Time | Average Case Time | Worst Case Time | Space Complexity |
|--------------|-----------|----------------|--------------------|-----------------|------------------|
| **Linear Search** | Iterative  | O(1)          | O(n)              | O(n)            | O(1)             |
|              | Recursive  | O(1)          | O(n)              | O(n)            | O(n) (due to recursion stack) |
| **Binary Search** | Iterative  | O(1)          | O(log n)          | O(log n)        | O(1)             |
|              | Recursive  | O(1)          | O(log n)          | O(log n)        | O(log n) (due to recursion stack) |
| **Bubble Sort** | Iterative  | O(n)          | O(n²)             | O(n²)           | O(1)             |
|               | Recursive  | O(n)          | O(n²)             | O(n²)           | O(n) (due to recursion stack) |



4. Selection Sort
Description: Divides the input list into a sorted and an unsorted region, repeatedly selects the smallest element from the unsorted region to add to the sorted region.
Time Complexity: 
Space Complexity:


5. Insertion Sort
Description: Builds the final sorted array one item at a time, by repeatedly inserting a new element into the sorted portion of the array.
Time Complexity: 
Space Complexity:


6. Merge Sort
Description: Divides the array into two halves, recursively sorts them, and then merges the sorted halves.
**Working Principle**
- Divide: The array is recursively divided into two halves until each subarray has one element.
- Conquer: The subarrays are sorted recursively.
- Combine: The sorted subarrays are merged to form the final sorted array.

**Time Complexity**

| Case| Complexity |
|-----|------------|
| Best Case| O(n log n) |
| Average Case | O(n log n) |
| Worst Case | O(n log n) |

Since the array is divided into two halves at each step and merging takes O(n) time, the total time complexity is O(n log n).

**Space Complexity**
- Merge Sort requires O(n) auxiliary space due to the temporary arrays used for merging.
-  The recursive calls contribute to an additional O(log n) space complexity for the function call stack.


7. Quick Sort
Description: Selects a 'pivot' element and partitions the other elements into two sub-arrays according to whether they are less than or greater than the pivot.
**Working Principle**
- Divide: A pivot element is chosen, and the array is partitioned such that elements smaller than the pivot are placed on the left and larger elements on the right.
- Conquer: Quick Sort is recursively applied to the left and right partitions.
- Combine: The sorted partitions are combined (implicitly achieved through recursion).

**Time Complexity**

| Case | Complexity |
|-----|------------|
| Best Case | O(n log n) |
|Average Case | O(n log n) |
| Worst Case | O(n^2) |

- The worst-case occurs when the pivot consistently picks the smallest or largest element, leading to unbalanced partitions.
- Choosing an optimal pivot (e.g., median of three) improves efficiency.

**Space Complexity**
- In-place sorting: Quick Sort generally requires O(log n) space for recursive function calls.
- In the worst case, the recursive depth may be O(n) (if partitions are highly unbalanced).
- No additional auxiliary arrays are needed, unlike Merge Sort.


8. Breadth-First Search (BFS)
Description: Explores a graph level by level, visiting all neighbors of a node before moving to the next level.
Time Complexity: 
Space Complexity:


9. Depth-First Search (DFS)
Description: Explores a graph by going as deep as possible along each branch before backtracking.
Time Complexity: 
Space Complexity:


10. Dijkstra's Algorithm
Description: Finds the shortest paths between nodes in a graph with non-negative edge weights.
Time Complexity: 
Space Complexity:


11. Floyd-Warshall Algorithm
Description: Finds shortest paths between all pairs of vertices in a weighted graph.
Time Complexity: 
Space Complexity:


12. Knapsack Problem (Dynamic Programming)
Description: Determines the most valuable combination of items that can be carried in a knapsack of limited weight.
Time Complexity: 
Space Complexity:


13. Fibonacci Sequence (Recursive)
Description: Calculates the nth Fibonacci number using recursive calls.
Time Complexity: 
Space Complexity:


14. Fibonacci Sequence (Dynamic Programming)
Description: Calculates the nth Fibonacci number using a bottom-up approach with memoization.
Time Complexity: 
Space Complexity:


15. Matrix Multiplication (Naive)
Description: Naïve Matrix Multiplication follows the standard row-column method to multiply two matrices. 
**Time Complexity:**
- Best-case Complexity: O(mnp)
- Worst-case Complexity: O(mnp)

Since each element requires n multiplications and additions, the complexity remains O(mnp) in all cases.

**Space Complexity:**
- The space required to store the resulting matrix C is O(mp).

If auxiliary storage is considered, additional space is minimal, so the space complexity remains O(mp).


## Time Complexity Table

| Algorithm | Best Case | Average Case | Worst Case | Explanation |
|-----------|-----------|--------------|------------|-------------|
| Linear Search |	O(1) |	O(n) |	O(n) |	Best case: target found at first index. Worst case: last index or not found. |
| Binary Search |	O(1) |	O(log n) |	O(log n) | Best case: target found in the middle. Worst case: search space halves repeatedly. |
|-----------|-----------|--------------|------------|-------------|
| Bubble Sort |	O(n) |	O(n²) |	O(n²) |	Best case: already sorted array, single pass. Worst case: full passes with swaps. |
| Insertion Sort |	O(n) |	O(n²) |	O(n²) |	Best case: nearly sorted array. Worst case: shifting elements for each insertion. |
| Selection Sort |	O(n²) |	O(n²) |	O(n²) |	Always makes comparisons for each selection, no best-case improvement. |
| Merge Sort |	O(n log n) |	O(n log n) |	O(n log n) | Recursively splits and merges arrays. |
| Quicksort |	O(n log n) |	O(n log n) |	O(n²) |	Worst case: poor pivot selection, causing unbalanced partitions. |
|-----------|-----------|--------------|------------|-------------|
| DFS (Graph Traversal) |	O(1) |	O(V + E) |	O(V + E) |	Best case: goal node found immediately. Worst case: visits all vertices and edges. |
| BFS (Graph Traversal) |	O(1) |	O(V + E) |	O(V + E) |	Similar to DFS but processes nodes level by level. |
|-----------|-----------|--------------|------------|-------------|


Note: For each algorithm, consider:
- Best case scenario
- Average case scenario
- Worst case scenario
- Any space complexity variations based on implementation

Can you help fill in the missing complexities? Create a PR with your solutions!
