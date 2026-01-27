/*
Problem: Daily Temperatures (LeetCode 739)
Difficulty: Medium
Tags: stack, monotonic-stack, arrays

Intuition:
--------------------------------------------------
For each day, we want to know how many days we must wait
until a warmer temperature appears.

A brute-force approach would check all future days for
each index, resulting in O(n^2) time - too slow.

This problem is a classic application of the
"Next Greater Element" pattern using a Monotonic Stack.

--------------------------------------------------
Approach (Monotonic Decreasing Stack):
--------------------------------------------------
- Use a stack to store indices of days.
- Maintain the stack such that temperatures at stored
  indices are in decreasing order.
- Traverse the array from left to right:
    - While the stack is not empty and the current
      temperature is greater than the temperature at
      the index on top of the stack:
        - Pop the index from the stack.
        - The difference between current index and
          popped index is the waiting days.
    - Push the current index onto the stack.
- Any indices left in the stack have no warmer future day,
  so their result remains 0.

--------------------------------------------------
Time Complexity:
--------------------------------------------------
O(n) — each index is processed at most twice.

--------------------------------------------------
Space Complexity:
--------------------------------------------------
O(n) — stack can hold up to n indices.
--------------------------------------------------
*/
vector<int> dailyTemperatures(vector<int>& temperatures) {
    int n = temperatures.size();
    vector<int> result(n, 0);
    stack<int> st;

    for (int i = 0; i < n; i++) {
        while (!st.empty() && temperatures[st.top()] < temperatures[i]) {
            int prevIndex = st.top();
            st.pop();
            result[prevIndex] = i - prevIndex;
        }
        st.push(i);
    }

    return result;
}
