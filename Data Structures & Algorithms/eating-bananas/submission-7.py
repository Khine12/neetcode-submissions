class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        n = len(piles)
        m = max(piles)
        piles = sorted(piles)
        if n == h:
            return m
        l = min(piles)
        while l < m:
            mid = (l+m)//2
            total = sum((pile+mid-1)//mid for pile in piles)
            if total <= h:
                m = mid
            else:
                l = mid + 1
        return l