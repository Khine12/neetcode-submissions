class Solution:
    def checkValidString(self, s: str) -> bool:
        c_min = 0
        c_max = 0
        for c in s:
            if c == '(':
                c_min += 1
                c_max += 1
            elif c == ')':
                c_min -= 1
                c_max -= 1
            else:
                c_min -= 1
                c_max += 1
            if c_max < 0:
                return False
            c_min = max(c_min,0)
        return True if c_min == 0 else False