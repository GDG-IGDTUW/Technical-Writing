Difficulty: Medium
Tags: stack, monotonic-stack, arrays

Problem Reference:

Platform: LeetCode
Link: https://leetcode.com/problems/daily-temperatures/

Concept to Read:

https://www.geeksforgeeks.org/daily-temperatures/

Monotonic Stack (Next Greater Element variant)

Issue Description:
Given an array of daily temperatures, return an array where each index represents how many days one must wait until a warmer temperature.
If no such day exists, return 0.

This problem reinforces the next greater element pattern using a monotonic decreasing stack.

Acceptance Criteria:

Correct waiting days for each index

Returns 0 when no warmer day exists

Time Complexity: O(n)

Space Complexity: O(n)