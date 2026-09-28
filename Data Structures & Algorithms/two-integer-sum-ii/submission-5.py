class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        left = 1
        right = len(numbers)
        while left < right:
            k = numbers[left-1] + numbers[right-1]
            if k == target:
                return[left,right]
            elif k > target:
                right -= 1
            else:
                left += 1
        return [-1,-1]