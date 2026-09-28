class Solution:
    def maxArea(self, heights: List[int]) -> int:
        if len(heights) < 2:
            return 0
        left = 0
        right = len(heights)-1
        max_water = 0
        while left < right:
            max_water = max(max_water, (right-left)*min(heights[left],heights[right]))
            if heights[left] < heights[right]:
                left += 1
            else:
                right -= 1
        return max_water