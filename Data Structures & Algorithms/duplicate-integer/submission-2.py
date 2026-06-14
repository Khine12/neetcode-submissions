class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        bag = set()
        for i in nums:
            if i in bag:
                return True
            bag.add(i)
        return False