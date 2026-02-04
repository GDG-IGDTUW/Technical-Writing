import java.util.*;

class StockSpanner {

    // Stack stores pairs: [price, span]
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        // Pop all prices less than or equal to current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.peek()[1];
            stack.pop();
        }

        // Push current price with its span
        stack.push(new int[]{price, span});

        return span;
    }
}
