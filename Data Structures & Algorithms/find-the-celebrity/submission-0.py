# The knows API is already defined for you.
# return a bool, whether a knows b
# def knows(a: int, b: int) -> bool:

class Solution:
    def findCelebrity(self, n: int) -> int:
        cel = 0
        for i in range(1,n):
            if knows(cel,i):
                cel = i
        for i in range(n):
            if i != cel:
                if knows(cel,i) or not knows(i,cel):
                    return -1
        return cel