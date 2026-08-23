class Solution:
    def isPalindrome(self, s: str) -> bool:
        string = ""
        for k in s:
            if k.isalnum():
                string += k
            else:
                continue
        string = string.lower()
        left = 0
        right = len(string)-1
        while left < right:
            if string[left] != string[right]:
                return False
            left += 1
            right -= 1
        return True