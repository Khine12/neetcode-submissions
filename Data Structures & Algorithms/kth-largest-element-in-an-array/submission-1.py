import heapq

class Solution:

    def findKthLargest(self, nums: List[int], k: int) -> int:
        
        self.heap = []
        self.k = k

        for x in nums:

            heapq.heappush(self.heap,x)

            if len(self.heap) > self.k:

                heapq.heappop(self.heap)

        return self.heap[0]