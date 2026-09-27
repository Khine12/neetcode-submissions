class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        collection = {}

        for num in nums:
            if num not in collection:
                collection[num] = 1
            else:
                collection[num] += 1
            
        sorted_k = sorted(collection.items(), key=lambda item:item[1], reverse=True)
        return [key for key,value in sorted_k[:k]]