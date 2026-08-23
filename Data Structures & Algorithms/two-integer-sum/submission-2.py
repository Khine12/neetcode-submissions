class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        storage = {}
        for i in range(len(nums)):
            need = target - nums[i]
            if need in storage.values():
                for y in storage:
                    if storage[y] == need:
                        if i < y:
                            return [i,y]
                        else:
                            return [y,i]

            storage[i] = nums[i]
        return [-1,-1]