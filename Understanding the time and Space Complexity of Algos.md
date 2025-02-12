Common Algorithms and Their Complexities

This document lists various algorithms and their time/space complexities. Some complexities are missing - can you help fill them in?

1. Linear Search
Description: Sequentially checks each element in a list until a match is found or the end of list is reached.
Time Complexity: 
Space Complexity:

2. Binary Search
Description: Repeatedly divides a sorted array in half, eliminating the half that cannot contain the target value.
Time Complexity: 
Space Complexity:

3. Bubble Sort
Description: Repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order.
Time Complexity: 
Space Complexity:


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
    
**Description:** Calculates the nth Fibonacci number using recursive calls. This results in Recurrence relation as:
- F(n)=F(n-1) + F(n-2)

**Time Complexity:** `O(2^n)`
- Each Fibonacci number is calculated using 2 recursive calls.
- This creates an exponential number of function calls.
- The recurrence tree has a depth of n and and at each level the number of calls double, leading to exponential time complexity.
  
```java
public static int fib(int n) {
		if(n==0) {
			return 0;
		}
		
		if(n==1) {
			return 1;
		}
		
		return fib(n-1)+fib(n-2);
  }
```

**Space Complexity:** `O(n)`
- The recursion stack has a depth of n as the function calls reach to the base case.
- An example representation:
  ![Image](https://github.com/user-attachments/assets/107309a2-4d7e-4f92-8788-5936cccd1dda)

15. Fibonacci Sequence (Dynamic Programming)
Description: Calculates the nth Fibonacci number using a bottom-up approach with memoization.
Time Complexity: 
Space Complexity:


16. Matrix Multiplication (Naive)
Description: Multiplies two matrices using the standard row-column multiplication method.
Time Complexity: 
Space Complexity:


Note: For each algorithm, consider:
- Best case scenario
- Average case scenario
- Worst case scenario
- Any space complexity variations based on implementation

Can you help fill in the missing complexities? Create a PR with your solutions!
