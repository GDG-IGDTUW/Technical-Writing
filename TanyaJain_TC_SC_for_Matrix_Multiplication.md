# Naïve Matrix Multiplication

## Overview
Naïve Matrix Multiplication follows the standard row-column method to multiply two matrices. Given two matrices:

A of size m × n
B of size n × p

The resulting matrix C will have dimensions m × p, where each element is computed as:


## Time Complexity
- Best-case Complexity: O(mnp)
- Worst-case Complexity: O(mnp)

Since each element requires n multiplications and additions, the complexity remains O(mnp) in all cases.

## Space Complexity
- The space required to store the resulting matrix C is O(mp).

If auxiliary storage is considered, additional space is minimal, so the space complexity remains O(mp).


## Applications
- Computer graphics transformations
- Scientific computing
- Machine learning and deep learning computations
- Engineering simulations

## Limitations
1. Inefficiency: The naive approach is slow for large matrices due to its O(mnp) complexity.
2. Better Alternatives: Strassen’s Algorithm (O(n^{2.81})) and more optimized methods like the Coppersmith-Winograd Algorithm are used for faster computations.