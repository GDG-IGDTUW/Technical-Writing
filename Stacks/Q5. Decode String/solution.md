## Approach

This problem can be solved efficiently using a **stack-based approach**.

### Key Idea

While iterating through the string:

- **Digits** are used to build the repeat count `k`.
- **'['** indicates the start of an encoded substring:
  - Push the current string and current number onto the stack.
  - Reset both for the new context.
- **']'** indicates the end of an encoded substring:
  - Pop the last stored string and repeat count from the stack.
  - Append the current decoded substring `k` times.
- **Letters** are appended directly to the current working string.

This handles nested encodings naturally via the stack.

---

## Algorithm

1. Initialize:
   - A stack to store `(previous_string, repeat_count)`.
   - An empty current string.
   - A variable `num = 0` to build repeat counts.
2. Traverse each character in the string:
   - If digit: update `num`.
   - If `'['`: push `(current_string, num)` to stack, reset both.
   - If `']'`: pop from stack and expand current string.
   - Else: append character to current string.
3. Return the final string.

---

## Complexity Analysis

- **Time Complexity:** `O(N)`  
  Each character is processed once, and total output size is bounded by `10^5`.

- **Space Complexity:** `O(N)`  
  For the stack and the decoded output.

---

## C++ Implementation

```cpp
#include <string>
#include <stack>

using namespace std;

class Solution {
public:
    string decodeString(string s) {
        stack<pair<string, int>> st;
        string current = "";
        int num = 0;

        for (char c : s) {
            if (isdigit(c)) {
                num = num * 10 + (c - '0');
            } 
            else if (c == '[') {
                st.push({current, num});
                current = "";
                num = 0;
            } 
            else if (c == ']') {
                auto [prev, repeat] = st.top();
                st.pop();
                string expanded = "";
                for (int i = 0; i < repeat; i++) {
                    expanded += current;
                }
                current = prev + expanded;
            } 
            else {
                current += c;
            }
        }

        return current;
    }
```
};
