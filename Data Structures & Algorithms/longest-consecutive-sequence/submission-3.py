class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0
        k = set(nums)
        max_count = 0

        for num in k:
            if num-1 not in k:
                curr = num
                count = 1
                while curr+1 in k:
                    count = count + 1
                    curr = curr + 1

            max_count = max(max_count,count)

        return max_count