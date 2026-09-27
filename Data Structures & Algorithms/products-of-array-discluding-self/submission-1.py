class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [1]*n
        prefix = self.prefix(nums)
        suffix = self.suffix(nums)

        for i in range(n):
            result[i] = prefix[i]*suffix[i]
        return result
        
    def prefix(self,nums):
        n = len(nums)
        prefix = [1]*n
        
        for i in range(1,n):
            prefix[i] = prefix[i-1]*nums[i-1]
        return prefix

    def suffix(self,nums):
        n = len(nums)
        suffix = [1]*n

        for i in range(n-2,-1,-1):
            suffix[i] = suffix[i+1]*nums[i+1]
        return suffix