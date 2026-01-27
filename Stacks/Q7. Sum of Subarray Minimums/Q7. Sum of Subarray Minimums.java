import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = (int)1e9 + 7;
        
        // Arrays to store NSE and PSE indices
        int[] nse = new int[n];
        int[] pse = new int[n];
        
        //NSE (Next Smaller Element)
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                nse[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            nse[stack.pop()] = n; // no smaller element to right
        }
        
        //PSE (Previous Smaller Element)
        stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                pse[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            pse[stack.pop()] = -1; // no smaller element to left
        }
        
        // Calculating total sum
        long total = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            total = (total + (long)arr[i] * left * right) % mod;
        }
        
        return (int)total;
    }
}