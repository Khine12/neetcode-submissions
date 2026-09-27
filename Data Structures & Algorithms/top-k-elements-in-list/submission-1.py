class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        collection = {}
        result = []

        for num in nums:
            if num not in collection:
                collection[num] = 1
            else:
                collection[num] += 1
            
        for key,value in collection.items():
            if value >= k:
                result.append(key)
        return result