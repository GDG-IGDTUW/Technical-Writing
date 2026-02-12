import java.util.*;

class Solution {

    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;

        int[] pse = new int[n];
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Previous Smaller Element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Answer array
        int[] ans = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int len = nse[i] - pse[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }

        // Fill remaining
        for (int i = n - 1; i >= 1; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }

        // Convert to ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(ans[i]);
        }

        return result;
    }
}
