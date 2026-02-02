class Solution:
    def validateStackSequences(self, pushed, popped):
        stack = []
        j = 0  # pointer for popped

        for x in pushed:
            stack.append(x)

            # pop while top matches popped sequence
            while stack and j < len(popped) and stack[-1] == popped[j]:
                stack.pop()
                j += 1

        return j == len(popped)
