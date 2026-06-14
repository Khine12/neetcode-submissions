import heapq
from collections import Counter

class Solution:

    def leastInterval(self, tasks: List[str], n: int) -> int:

        freq = Counter(tasks)

        maxHeap = [-s for s in freq.values()]

        heapq.heapify(maxHeap)

        cooldown = deque()

        time = 0

        while maxHeap or cooldown:

            time += 1

            if maxHeap:

                cnt = heapq.heappop(maxHeap)

                cnt += 1

                if cnt != 0:

                    cooldown.append((time+n,cnt))

            if cooldown and cooldown[0][0] == time:

                heapq.heappush(maxHeap, cooldown.popleft()[1])
        return time