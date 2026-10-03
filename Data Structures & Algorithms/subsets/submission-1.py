class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        sub = []

        def dts(i):
            if i == len(nums):
                res.append(sub.copy())
                return
            sub.append(nums[i])
            dts(i+1)

            sub.pop()
            dts(i+1)

        dts(0)
        return res