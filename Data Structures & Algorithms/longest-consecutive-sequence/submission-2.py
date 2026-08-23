class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        store = set()
        max_sequence = 0
        for num in nums:
           store.add(num)
        for n in store:
            count = 0
            if n-1 not in store:
                current = n
                count = 1
                while current+1 in store:
                    count += 1
                    current += 1
            max_sequence = max(max_sequence,count)
        return max_sequence
