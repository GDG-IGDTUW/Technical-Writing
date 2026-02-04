# Issue 6: Ways to Split Array Into Three Subarrays

**Difficulty:** Medium  
**Tags:** arrays, prefix-sum, binary-search, greedy  

---

## Problem Reference

- **Title:** Ways to Split Array Into Three Subarrays  
- **Platform:** LeetCode  
- **Link:** https://leetcode.com/problems/ways-to-split-array-into-three-subarrays/

---

## Concept to Read

- Prefix Sum Technique  
- Binary Search  
- Greedy Strategy  

Reference:  
https://www.geeksforgeeks.org/prefix-sum-array-implementation-applications-competitive-programming/

---

## Issue Description

Given a non-negative integer array `nums`, count the number of ways to split the array into **three non-empty contiguous subarrays** (`left`, `mid`, `right`) such that:

- `sum(left) ≤ sum(mid)`
- `sum(mid) ≤ sum(right)`

The answer must be returned modulo **10⁹ + 7**.

---

## Approach

1. Compute the prefix sum array to allow constant-time subarray sum queries.
2. Fix the ending index of the `left` subarray.
3. Use **binary search** to find:
   - The first valid split point where `sum(mid) ≥ sum(left)`
   - The last valid split point where `sum(mid) ≤ sum(right)`
4. The number of valid splits for a fixed `left` is the size of this valid range.
5. Accumulate results for all valid left partitions.

This approach works efficiently due to the non-decreasing nature of prefix sums.

---

## Solution Code (C++)

```cpp
class Solution {
public:
    int waysToSplit(vector<int>& nums) {
        const int MOD = 1e9 + 7;
        int n = nums.size();
        
        vector<long long> pre(n);
        pre[0] = nums[0];
        for (int i = 1; i < n; i++)
            pre[i] = pre[i - 1] + nums[i];
        
        long long ans = 0;

        for (int i = 0; i < n - 2; i++) {
            long long leftSum = pre[i];

            int l = i + 1, r = n - 2;
            int first = -1;

            // Find first valid mid
            while (l <= r) {
                int mid = (l + r) / 2;
                if (pre[mid] >= 2 * leftSum) {
                    first = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            if (first == -1) continue;

            l = first;
            r = n - 2;
            int last = -1;

            // Find last valid mid
            while (l <= r) {
                int mid = (l + r) / 2;
                if (pre[mid] <= (pre[n - 1] + leftSum) / 2) {
                    last = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            if (last != -1)
                ans = (ans + (last - first + 1)) % MOD;
        }

        return ans;
    }
};
