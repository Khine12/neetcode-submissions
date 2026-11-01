class Solution:
    def checkValidString(self, s: str) -> bool:
        stack = []
        for i in range(len(s)):
            if len(stack) == 0:
                stack.append(s[i])
            else:
                if (s[i] == ')' or s[i] =="*") and (stack[-1] == '(' or stack[-1] == "*"):
                    stack.pop()
                elif s[i] == "*":
                    stack.append(s[i])
        return True if len(stack) == 0 else False