# Solution: Minimum Average of Smallest and Largest Elements

## Approach

To find the minimum average formed by repeatedly removing the smallest and largest elements:

1. **Sort the array** so the smallest and largest elements are easily accessible.
2. Use a **two-pointer style traversal**:
   - One pointer starts from the beginning (smallest element).
   - The other pointer is implicitly from the end (largest element).
3. For each pair:
   - Compute their average.
   - Track the minimum average encountered.
4. Since each iteration removes two elements, we only need to iterate `n / 2` times.
5. If the array length is odd, the middle element is ignored, which is valid as per the problem.

---

## Algorithm

1. Sort the input array.
2. Initialize `ans` with a very large value.
3. Loop from `i = 0` to `i < n / 2`:
   - Pair `nums[i]` with `nums[n - i - 1]`
   - Compute their average.
   - Update the minimum average.
4. Return the minimum average.

---

## C++ Implementation

```cpp
class Solution {
public:
    double minimumAverage(vector<int>& nums){
        sort(nums.begin(), nums.end());

        double ans = DBL_MAX;
        int n = nums.size();

        for(int i = 0; i < n / 2; i++){
            double d = (nums[i] + nums[n - i - 1]) / 2.0;
            ans = min(ans, d);
        }

        return ans;
    }
};
```
---
## Complexity Analysis

- Time Complexity: O(n log n) due to sorting
- Space Complexity: O(1) (no extra data structures used)
