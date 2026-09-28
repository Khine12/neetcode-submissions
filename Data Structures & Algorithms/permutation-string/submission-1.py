class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        m = len(s1)
        n = len(s2)
        if m > n:
            return False
        c = Counter(s1)
        window = Counter(s2[:m])
        if c == window:
            return True

        for i in range(m,n):
            window[s2[i]] += 1
            window[s2[i-m]] -= 1
            if window[s2[i-m]] == 0:
                del window[s2[i-m]]
            if window == c:
                return True

        return False