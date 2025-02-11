# Time Complexity Analysis: Best, Average, and Worst Case

## Introduction
Time complexity is a fundamental concept in computer science that helps us evaluate the efficiency of an algorithm. It describes the amount of time an algorithm takes to complete as a function of the input size (denoted as n).

Understanding the best, average, and worst-case time complexities is essential for choosing the most appropriate algorithm for a given problem.

1. Best-Case Complexity
    (a) Definition: The best-case complexity represents the minimum time an algorithm takes to run for the most favorable input.

    (b) Interpretation: This scenario occurs when the input requires the least number of operations. It provides an optimistic estimate but is not always practically useful.


Examples:
- Searching (Linear Search): Given an array [1, 2, 3, 4, 5], if we search for 1, the algorithm finds it in the first comparison.

Best-case complexity: O(1) (first element is the target).

- Sorting (Bubble Sort): If the array is already sorted, Bubble Sort only makes a single pass to confirm order.

Best-case complexity: O(n) (single pass, no swaps).

- Graph Traversal (BFS/DFS): If the target node is found immediately at the first depth level, minimal traversal is required.

Best-case complexity: O(1) (early termination upon finding the goal node).

2. Average-Case Complexity
    (a) Definition: The average-case complexity represents the expected runtime for a random input.

    (b) Interpretation: This is determined by averaging all possible inputs. It provides a realistic expectation of performance.

Examples: 
- Searching (Linear Search): Searching for a random element in an unordered array of size n will, on average, take n/2 comparisons.

Average-case complexity: O(n).

- Sorting (Quicksort): When the pivot is randomly chosen, the input is divided into subarrays of approximately equal size.

Average-case complexity: O(n log n).

- Graph Traversal (Dijkstra’s Algorithm): If a graph has V vertices and E edges, Dijkstra’s algorithm with a binary heap runs in O((V+E) log V).

3. Worst-Case Complexity
    (a) Definition: The worst-case complexity represents the maximum time an algorithm takes to run for the least favorable input.

    (b) Interpretation: This is the upper bound on the algorithm’s runtime. It is crucial for ensuring worst-case performance guarantees.

Examples
- Searching (Binary Search): When searching for an absent element in a sorted array, the algorithm will continue until it checks all possible divisions.

Worst-case complexity: O(log n).

- Sorting (Quicksort with Worst Pivot Selection): If Quicksort always picks the largest or smallest element as the pivot, the array is divided in the worst way.

Worst-case complexity: O(n²).

- Graph Traversal (DFS on a Dense Graph): If all nodes are connected, DFS visits every node and edge.

Worst-case complexity: O(V + E).


## Conclusion
Understanding best, average, and worst-case time complexities helps in making informed decisions about algorithm selection. While best-case scenarios provide an optimistic view, average and worst-case complexities are more useful in real-world applications. The choice of algorithm should be based on expected input distributions and performance guarantees.

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
| Heap Sort |	O(n log n) |	O(n log n) |	O(n log n) |	Always maintains a balanced heap structure. |
|-----------|-----------|--------------|------------|-------------|
| DFS (Graph Traversal) |	O(1) |	O(V + E) |	O(V + E) |	Best case: goal node found immediately. Worst case: visits all vertices and edges. |
| BFS (Graph Traversal) |	O(1) |	O(V + E) |	O(V + E) |	Similar to DFS but processes nodes level by level. |
|-----------|-----------|--------------|------------|-------------|