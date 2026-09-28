class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left = 0
        max_length = 0
        c = set()

        for right in range(len(s)):
            while s[right] in c:
                c.remove(s[left])
                left += 1
            c.add(s[right])
            max_length = max(max_length, right-left+1)
                
        return max_length