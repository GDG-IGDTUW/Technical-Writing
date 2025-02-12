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
Time Complexity: 
Space Complexity:


7. Quick Sort
Description: Selects a 'pivot' element and partitions the other elements into two sub-arrays according to whether they are less than or greater than the pivot.
Time Complexity: 
Space Complexity:


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

**Applications**
- Computer graphics transformations
- Scientific computing
- Machine learning and deep learning computations
- Engineering simulations

**Limitations**
1. Inefficiency: The naive approach is slow for large matrices due to its O(mnp) complexity.
2. Better Alternatives: Strassen’s Algorithm (O(n^{2.81})) and more optimized methods like the Coppersmith-Winograd Algorithm are used for faster computations.

---
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

---

Note: For each algorithm, consider:
- Best case scenario
- Average case scenario
- Worst case scenario
- Any space complexity variations based on implementation

Can you help fill in the missing complexities? Create a PR with your solutions!

---
### **Recursive vs. Iterative Algorithms: Space Complexity Comparison**  

Algorithms can be implemented using **recursion** or **iteration**, but they differ in **space complexity** due to how they manage memory.  

---

## **1. Understanding Space Complexity in Recursion**  
### How Recursion Uses Memory:  
- Recursive algorithms use the **call stack** to store function calls until they return.  
- Each recursive call **adds a new stack frame**, increasing space usage.  
- The recursion **depth determines space complexity**.  

### **Example: Quick Sort (Recursive)**
- **Space Complexity:** `O(log n)` (average case), `O(n)` (worst case when unbalanced).  
- **Reason:** The recursive function calls store partitions on the stack.  

#### **Pseudocode for Recursive Quick Sort**
```python
function quickSort(arr, low, high):
    if low < high:
        pivotIndex = partition(arr, low, high)
        quickSort(arr, low, pivotIndex - 1)  # Recursive call for left subarray
        quickSort(arr, pivotIndex + 1, high) # Recursive call for right subarray
```
- **Recursive Depth:** `O(log n)` in the best case but `O(n)` in the worst case (skewed partitioning).  
- **Memory Usage:** Each function call adds a new stack frame.  

---

## **2. Understanding Space Complexity in Iterative Algorithms**  
### How Iteration Saves Space:  
- Iterative algorithms **do not use the call stack** for recursive function calls.  
- Instead, they use **loop constructs**, requiring **constant space (`O(1)`)** if no extra data structures are needed.  

### **Example: Merge Sort (Iterative)**
- **Space Complexity:** `O(n)` (due to auxiliary array for merging).  
- **Reason:** Avoids recursion stack, but still requires temporary storage for merging.  

#### **Pseudocode for Iterative Merge Sort**
```python
function mergeSortIterative(arr):
    n = length(arr)
    currentSize = 1
    while currentSize < n:
        left = 0
        while left < n-1:
            mid = min(left + currentSize - 1, n-1)
            right = min(left + 2*currentSize - 1, n-1)
            merge(arr, left, mid, right)
            left += 2 * currentSize
        currentSize *= 2
```
- **No recursion stack used** → avoids `O(log n)` recursive call overhead.  
- **Still requires `O(n)` auxiliary space** for merging.  

---

## **3. Comparing Recursive vs. Iterative Implementations**  

| Algorithm | Recursive Space Complexity | Iterative Space Complexity |  
|-----------|---------------------------|---------------------------|  
| Quick Sort | `O(log n)` (best/avg), `O(n)` (worst) | `O(1)` (if stack avoided) |  
| Merge Sort | `O(n)` (auxiliary array + recursion depth) | `O(n)` (auxiliary array) |  
| Fibonacci | `O(n)` (due to recursion depth) | `O(1)` (loop-based) |  
| DFS | `O(h)`, where `h` is tree/graph depth | `O(n)` (if stack used explicitly) |  
| BFS | `O(n)` (queue storage) | `O(n)` (queue storage) |  

---
## **How Recursion Impacts Space Usage with Stack Frames**  

### **What Happens in Memory During Recursion?**  
When a function calls itself recursively, the system **allocates memory** on the **call stack** for each function call. These stack frames store:  
- **Function parameters**  
- **Local variables**  
- **Return address (where to continue execution after returning)**  

Each recursive call **adds a new stack frame**, and these frames remain in memory until the function returns. If recursion is too deep, it can cause **stack overflow**.

---

### **Example: Recursive Fibonacci Calculation**
Let's take a simple recursive Fibonacci function:
```python
def fibonacci(n):
    if n <= 1:
        return n
    return fibonacci(n-1) + fibonacci(n-2)
```
- **Function Calls for `fibonacci(4)`:**  
```
fibonacci(4)  
├── fibonacci(3)  
│   ├── fibonacci(2)  
│   │   ├── fibonacci(1) → returns 1  
│   │   ├── fibonacci(0) → returns 0  
│   ├── fibonacci(1) → returns 1  
├── fibonacci(2)  
│   ├── fibonacci(1) → returns 1  
│   ├── fibonacci(0) → returns 0  
```
- **Stack Frame Growth (Call Stack):**
```
fibonacci(4)
  fibonacci(3)
    fibonacci(2)
      fibonacci(1)  (returns)
      fibonacci(0)  (returns)
    fibonacci(1)  (returns)
  fibonacci(2)
    fibonacci(1)  (returns)
    fibonacci(0)  (returns)
```
- **Space Complexity:** `O(n)` (for call stack depth).  
- **Problem:** Many redundant calls (`fibonacci(2)` appears twice).  

---

### **Recursion vs. Iteration: Call Stack Usage**  
| Approach | Space Complexity | Why? |
|----------|----------------|------|
| **Recursive Fibonacci** | `O(n)` | Each call adds a stack frame until `n` reaches 0. |
| **Iterative Fibonacci** | `O(1)` | Uses only a few variables, no extra function calls. |

---


