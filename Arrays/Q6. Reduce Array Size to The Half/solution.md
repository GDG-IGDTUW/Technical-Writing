# Issue 6: Reduce Array Size to The Half

**Difficulty:** Medium  
**Tags:** Arrays, Greedy, HashMap  

---

## Problem Reference

- **Title:** Reduce Array Size to The Half  
- **Platform:** LeetCode  
- **Link:** https://leetcode.com/problems/reduce-array-size-to-the-half/

---

## Problem Description

Given an integer array `arr`, you can remove all occurrences of any selected integer in one operation.  
The task is to remove elements such that **at least half of the array elements are removed**, while minimizing the **number of selected integers**.

---

## Concept Used

This problem is solved using a **Greedy Algorithm** approach combined with **frequency counting**.

Recommended reading:  
https://www.geeksforgeeks.org/greedy-algorithms/

---

## Approach

1. Count the frequency of each element in the array using a hash map.
2. Store all frequencies in a separate array.
3. Sort the frequencies in descending order.
4. Greedily remove elements with the highest frequency first.
5. Stop when the total removed elements reach at least half of the array size.
6. Return the number of elements removed (minimum set size).

---

## Solution Code (C++)

```cpp
class Solution {
public:
    int minSetSize(vector<int>& arr) {
        unordered_map<int, int> freq;
        for (int x : arr) {
            freq[x]++;
        }

        vector<int> counts;
        for (auto &it : freq) {
            counts.push_back(it.second);
        }

        sort(counts.begin(), counts.end(), greater<int>());

        int removed = 0;
        int operations = 0;
        int half = arr.size() / 2;

        for (int c : counts) {
            removed += c;
            operations++;
            if (removed >= half)
                break;
        }

        return operations;
    }
};
