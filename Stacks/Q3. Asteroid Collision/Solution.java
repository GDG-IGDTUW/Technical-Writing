import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {

                if (stack.peek() < -ast) {
                    stack.pop(); // top explodes
                    continue;
                } 
                else if (stack.peek() == -ast) {
                    stack.pop(); // both explode
                }

                destroyed = true;
                break;
            }

            if (!destroyed) {
                stack.push(ast);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
