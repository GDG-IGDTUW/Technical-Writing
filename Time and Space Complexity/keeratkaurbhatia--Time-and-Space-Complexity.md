# Time and Space Complexity

Before we talk about algorithms being *efficient* or *optimal*, we need to understand **what we actually mean by time and space** when code runs.

At the most primitive level, one can infer:

- **Time** → how long code takes to execute  
- **Space** → how much memory it uses while running  

You might think: "Just measure in seconds and MB, right?"

But that approach falls apart instantly.

Why?

- The same program behaves differently on different hardware
- What runs in 10ms for small input might take hours for large input
- Memory constraints vary across systems

So instead of measuring *actual* runtime and memory consumption, we use a **standardized way to reason about growth**.

---

## What Does "Complexity" Actually Mean?

**Complexity** tells us how **time or space requirements grow as input size increases**.

Instead of saying:

> "This took 4ms on my machine"

We can say:

> "This grows linearly with input size `n`"

Complexity answers one very important question:

> *How does performance scale when the problem gets bigger?*

---

## Why is it needed?

For most problems, there are **tons of correct solutions**.  

But that alone is NOT enough.

Think of it in such a way:

- One solution runs in 1 second for 10 items but takes 10 minutes for 1 million items  
- Another solution is slightly slower for small inputs but scales better

We want solutions that:

- **Minimize time** → faster execution  
- **Minimize space** → less memory usage

i.e., effectively reducing the cost.

This makes the solution more practical and scalable.

Complexity helps us **pick the best solution**, not just any working solution!

---

## Complexity Functions

Instead of counting seconds or bytes, we express time and space as a **function of input size `n`**.

### Simple Loop

```pseudo
for i = 0 to n-1
    print(i)
```

- Time depends on `n`
- Each iteration takes constant time
- If `n` doubles, loop takes roughly twice as long

**Time Complexity:** O(n)  
**Space Complexity:** O(1) — we're not storing anything extra

### Nested Loops

```pseudo
for i = 0 to n-1
    for j = 0 to n-1
        print(i, j)
```

- Outer loop: n iterations
- Inner loop: n iterations *for each* outer iteration
- Total operations = n × n = n²

**Time Complexity:** O(n²)  
**Space Complexity:** O(1)

### Recursion

```pseudo
function factorial(n)
    if n == 0
        return 1
    return n * factorial(n-1)
```

- Each function call gets added to the call stack
- Stack depth grows with n
- Each call waits for the next to finish

**Time Complexity:** O(n) — we make n calls  
**Space Complexity:** O(n) — recursion stack holds n frames

---

## Asymptotic Notations: Big O, Big Ω, Big Θ

These notations describe how time or space grows as input size increases.

- **Big O (O)** → Upper bound, worst case  
- **Big Ω (Ω)** → Lower bound, best case  
- **Big Θ (Θ)** → Tight bound, average case  

Note: These apply to **both time AND space**.

---

## Best, Average, and Worst Case

Algorithms behave differently depending on the actual input, even when inputs have the same size.

- **Best case (Ω)** → minimum time/space needed
- **Worst case (O)** → maximum time/space needed
- **Average case (Θ)** → expected time/space across typical inputs

---

# Common Time Complexities with Examples and Dry Runs

## O(1) — Constant Time

**What it means:** Time doesn't change regardless of input size. Whether you have 10 items or 10 million, it takes the same amount of time.

### Example: Array Access

```pseudo
function getFirstElement(arr)
    return arr[0]
```

### Dry Run

```
Input: arr = [5, 10, 15, 20, 25]

Execution:
Step 1: Access arr[0]
Step 2: Return 5

Total operations: 1 (always)
```

**Another test:**

```
Input: arr = [3, 7, 2, 9, 4, 1, 8, 6, 5] (9 elements)

Execution:
Step 1: Access arr[0]
Step 2: Return 3

Total operations: 1 (still!)
```

### Why O(1)?

Arrays store elements in contiguous memory. Each element has a fixed address:

- `arr[0]` is at memory address `base`
- `arr[1]` is at memory address `base + 1`
- `arr[i]` is at memory address `base + i`

To access `arr[0]`, we just go directly to `base`. No loop, no search. One step.

---

## O(log n) — Logarithmic Time

**What it means:** Time grows slowly. Each step cuts the problem size in half. Doubling the input only adds one more step.

### Example: Binary Search

```pseudo
function binarySearch(arr, target)
    left = 0
    right = length(arr) - 1
    
    while left <= right
        mid = (left + right) / 2
        
        if arr[mid] == target
            return mid
        else if arr[mid] < target
            left = mid + 1
        else
            right = mid - 1
    
    return -1
```

### Dry Run

```
Input: arr = [2, 5, 8, 12, 16, 23, 38, 45, 56, 67, 78]
       target = 23
       (Array length = 11)

Step 1:
  left = 0, right = 10
  mid = (0 + 10) / 2 = 5
  arr[5] = 23
  23 == 23 → FOUND!
  return 5

Total comparisons: 1
```

**Let's try searching for something that requires more steps:**

```
Input: arr = [2, 5, 8, 12, 16, 23, 38, 45, 56, 67, 78]
       target = 56

Step 1:
  left = 0, right = 10
  mid = (0 + 10) / 2 = 5
  arr[5] = 23
  23 < 56 → search RIGHT half
  left = 6

Step 2:
  left = 6, right = 10
  mid = (6 + 10) / 2 = 8
  arr[8] = 56
  56 == 56 → FOUND!
  return 8

Total comparisons: 2
```

**One more - element not found:**

```
Input: arr = [2, 5, 8, 12, 16, 23, 38, 45, 56, 67, 78]
       target = 50

Step 1:
  left = 0, right = 10
  mid = 5
  arr[5] = 23
  23 < 50 → search RIGHT
  left = 6

Step 2:
  left = 6, right = 10
  mid = 8
  arr[8] = 56
  56 > 50 → search LEFT
  right = 7

Step 3:
  left = 6, right = 7
  mid = 6
  arr[6] = 38
  38 < 50 → search RIGHT
  left = 7

Step 4:
  left = 7, right = 7
  mid = 7
  arr[7] = 45
  45 < 50 → search RIGHT
  left = 8

Step 5:
  left = 8, right = 7
  left > right → NOT FOUND
  return -1

Total comparisons: 4
```

### Why O(log n)?

Each comparison eliminates **half** the remaining elements:

- Start: 11 elements
- After step 1: ~5 elements
- After step 2: ~2 elements
- After step 3: ~1 element

With `n` elements, you need at most `log₂(n)` comparisons.

**For 11 elements:** log₂(11) ≈ 3.46, so worst case is 4 comparisons

**Think about it:**
- 1,000 elements → ~10 comparisons
- 1,000,000 elements → ~20 comparisons
- 1,000,000,000 elements → ~30 comparisons

That's the power of halving!

---

## O(n) — Linear Time

**What it means:** Time grows proportionally with input size. Double the input, double the time.

### Example: Finding Maximum

```pseudo
function findMax(arr)
    max = arr[0]
    for i = 1 to length(arr) - 1
        if arr[i] > max
            max = arr[i]
    return max
```

### Dry Run

```
Input: arr = [3, 7, 2, 9, 4, 1, 8]
       (Array length = 7)

Initialization:
  max = arr[0] = 3

Iteration 1 (i = 1):
  arr[1] = 7
  7 > 3? YES
  max = 7

Iteration 2 (i = 2):
  arr[2] = 2
  2 > 7? NO
  max = 7 (unchanged)

Iteration 3 (i = 3):
  arr[3] = 9
  9 > 7? YES
  max = 9

Iteration 4 (i = 4):
  arr[4] = 4
  4 > 9? NO
  max = 9 (unchanged)

Iteration 5 (i = 5):
  arr[5] = 1
  1 > 9? NO
  max = 9 (unchanged)

Iteration 6 (i = 6):
  arr[6] = 8
  8 > 9? NO
  max = 9 (unchanged)

Loop ends
Return max = 9

Total comparisons: 6 (n - 1)
```

### Why O(n)?

We must check **every single element** to guarantee we found the maximum.

- Can't skip any element (what if it's the max?)
- Must do n - 1 comparisons for n elements

**The pattern:**
- 10 elements → 9 comparisons
- 100 elements → 99 comparisons
- 1000 elements → 999 comparisons

Linear relationship: operations ≈ n

---

## O(n log n) — Linearithmic Time

**What it means:** Better than O(n²) but worse than O(n). Common in efficient sorting algorithms.

### Example: Merge Sort

```pseudo
function mergeSort(arr)
    if length(arr) <= 1
        return arr
    
    mid = length(arr) / 2
    left = mergeSort(arr[0 to mid-1])
    right = mergeSort(arr[mid to end])
    
    return merge(left, right)

function merge(left, right)
    result = []
    i = 0
    j = 0
    
    while i < length(left) and j < length(right)
        if left[i] <= right[j]
            append left[i] to result
            i = i + 1
        else
            append right[j] to result
            j = j + 1
    
    while i < length(left)
        append left[i] to result
        i = i + 1
    
    while j < length(right)
        append right[j] to result
        j = j + 1
    
    return result
```

### Dry Run

```
Input: arr = [38, 27, 43, 3]

Call: mergeSort([38, 27, 43, 3])
  length = 4, mid = 2
  
  Left half: mergeSort([38, 27])
    length = 2, mid = 1
    
    Left: mergeSort([38])
      length = 1 → return [38]
    
    Right: mergeSort([27])
      length = 1 → return [27]
    
    merge([38], [27]):
      Compare 38 vs 27 → 27 smaller
      result = [27]
      Compare 38 vs nothing → 38
      result = [27, 38]
    
    Return [27, 38]
  
  Right half: mergeSort([43, 3])
    length = 2, mid = 1
    
    Left: mergeSort([43])
      length = 1 → return [43]
    
    Right: mergeSort([3])
      length = 1 → return [3]
    
    merge([43], [3]):
      Compare 43 vs 3 → 3 smaller
      result = [3]
      Compare 43 vs nothing → 43
      result = [3, 43]
    
    Return [3, 43]
  
  Final merge([27, 38], [3, 43]):
    i=0, j=0: Compare 27 vs 3 → 3 smaller
    result = [3], j=1
    
    i=0, j=1: Compare 27 vs 43 → 27 smaller
    result = [3, 27], i=1
    
    i=1, j=1: Compare 38 vs 43 → 38 smaller
    result = [3, 27, 38], i=2
    
    i=2 (end of left): Add remaining right
    result = [3, 27, 38, 43]
  
  Return [3, 27, 38, 43]

Final sorted array: [3, 27, 38, 43]
```

### Visualising

```
                [38, 27, 43, 3]
                /              \
          [38, 27]              [43, 3]
          /      \              /      \
        [38]    [27]          [43]    [3]
          \      /              \      /
          [27, 38]              [3, 43]
                \              /
              [3, 27, 38, 43]

Depth of tree: log₂(4) = 2 levels
Work per level: O(n) merging
Total: O(n log n)
```

### Why O(n log n)?

**Two parts:**

1. **Dividing (log n levels):** We split the array in half repeatedly until we have single elements. This creates log₂(n) levels in the recursion tree.

2. **Merging (n work per level):** At each level, we merge all elements back together, which takes O(n) comparisons.

**For our example (n = 4):**
- Levels: log₂(4) = 2
- Work per level: 4 comparisons
- Total: 2 × 4 = 8 operations ≈ n log n

**Scaling:**
- 8 elements → 3 levels × 8 = 24 operations
- 16 elements → 4 levels × 16 = 64 operations
- 1000 elements → 10 levels × 1000 = 10,000 operations

---

## O(n²) — Quadratic Time

**What it means:** Time grows with the square of input size. Very slow for large inputs.

### Example: Bubble Sort

```pseudo
function bubbleSort(arr)
    n = length(arr)
    
    for i = 0 to n - 1
        for j = 0 to n - i - 2
            if arr[j] > arr[j + 1]
                swap(arr[j], arr[j + 1])
```

### Dry Run

```
Input: arr = [5, 2, 8, 1]
       n = 4

Pass 1 (i = 0):
  Inner loop runs from j = 0 to 1 (n - 0 - 2 = 2)
  
  j = 0: Compare arr[0] vs arr[1] → 5 > 2? YES
         Swap → arr = [2, 5, 8, 1]
  
  j = 1: Compare arr[1] vs arr[2] → 5 > 8? NO
         No swap → arr = [2, 5, 8, 1]
  
  j = 2: Compare arr[2] vs arr[3] → 8 > 1? YES
         Swap → arr = [2, 5, 1, 8]
  
  Largest element (8) bubbled to the end

Pass 2 (i = 1):
  Inner loop runs from j = 0 to 1 (n - 1 - 2 = 1)
  
  j = 0: Compare arr[0] vs arr[1] → 2 > 5? NO
         No swap → arr = [2, 5, 1, 8]
  
  j = 1: Compare arr[1] vs arr[2] → 5 > 1? YES
         Swap → arr = [2, 1, 5, 8]
  
  Second largest (5) in correct position

Pass 3 (i = 2):
  Inner loop runs from j = 0 to 0 (n - 2 - 2 = 0)
  
  j = 0: Compare arr[0] vs arr[1] → 2 > 1? YES
         Swap → arr = [1, 2, 5, 8]
  
  Third element in position

Pass 4 (i = 3):
  Inner loop runs from j = 0 to -1 (doesn't run)
  
  Array is sorted!

Final array: [1, 2, 5, 8]

Total comparisons:
Pass 1: 3 comparisons
Pass 2: 2 comparisons
Pass 3: 1 comparison
Total: 3 + 2 + 1 = 6 comparisons

For n = 4: (n-1) + (n-2) + ... + 1 = n(n-1)/2 = 6 ✓
```

### Why O(n²)?

**Nested loops:**

- Outer loop runs `n` times
- Inner loop runs approximately `n` times for each outer iteration
- Total operations ≈ n × n = n²

**Exact count:**
- First pass: n - 1 comparisons
- Second pass: n - 2 comparisons
- Third pass: n - 3 comparisons
- ...
- Last pass: 1 comparison

**Total:** (n-1) + (n-2) + ... + 1 = n(n-1)/2 ≈ n²/2

**The pattern:**
- 4 elements → 6 comparisons
- 10 elements → 45 comparisons
- 100 elements → 4,950 comparisons
- 1000 elements → 499,500 comparisons

Quadratic explosion!

---

# Space Complexity

## 1. Variables (constant space)

```pseudo
int a, b, c
```

Three integers, regardless of input size: O(1)

## 2. Data Structures (grows with n)

```pseudo
array temp[n]
```

Array of size n: O(n)

## 3. Recursion (stack memory)

```pseudo
function dfs(node)
    if node == null
        return
    dfs(node.left)
    dfs(node.right)
```

Maximum stack depth = height of tree
So in the worst case of a skewed tree: O(n)

## Recursion Stack Visualization

```
factorial(4)
│
├─ factorial(3)
│  │
│  ├─ factorial(2)
│  │  │
│  │  ├─ factorial(1)
│  │  │  │
│  │  │  └─ factorial(0) → returns 1
│  │  │
│  │  └─ returns 1 * 1 = 1
│  │
│  └─ returns 2 * 1 = 2
│
└─ returns 3 * 2 = 6

Stack depth = 5 frames = O(n)
```

---

# Time–Space Trade-offs

Sometimes, you cannot guarantee both time and space efficiency. So, often you can **trade space for time** or vice versa:

## Memoization (more space, less time)

**Without memoization:**

```pseudo
function fib(n)
    if n <= 1
        return n
    return fib(n-1) + fib(n-2)
```

Time: O(2ⁿ) — recalculates same values repeatedly  
Space: O(n) — recursion depth

**With memoization:**

```pseudo
memo = empty map

function fib(n)
    if n <= 1
        return n
    if n in memo
        return memo[n]
    
    memo[n] = fib(n-1) + fib(n-2)
    return memo[n]
```

Time: O(n) — calculates each value once  
Space: O(n) — memo storage + recursion stack

## In-place vs Auxiliary Space

**Bubble sort (in-place):**

```pseudo
function bubbleSort(arr)
    for i = 0 to n-1
        for j = 0 to n-i-1
            if arr[j] > arr[j+1]
                swap(arr[j], arr[j+1])
```

Time: O(n²)  
Space: O(1) — sorts in original array

**Merge sort (needs extra space):**

```pseudo
function mergeSort(arr)
    if length(arr) <= 1
        return arr
    
    mid = length(arr) / 2
    left = mergeSort(arr[0...mid])
    right = mergeSort(arr[mid...end])
    
    return merge(left, right)
```

Time: O(n log n)  
Space: O(n) — temporary arrays during merge

---

# Key Takeaway: 
**Good algorithms balance both, time AND memory. Hence the need for trade-offs.**


# Conclusion:

Think of complexity analysis as asking:

> "If my input size goes from 100 to 1,000,000, what happens to my program?"

That's exactly the question that matters in the real world!
