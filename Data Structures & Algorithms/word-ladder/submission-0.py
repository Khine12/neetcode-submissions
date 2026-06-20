from collections import deque,defaultdict
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:

        if endWord not in wordList:
            return 0
        
        storage = defaultdict(list)

        q = deque([beginWord])

        for word in wordList:
            for j in range(len(word)):

                part = word[:j] + "*" + word[j+1:]
                storage[part].append(word)

        visited = {beginWord}
        length = 1

        while q:

            for _ in range(len(q)):

                curr = q.popleft()

                if curr == endWord:

                    return length

                for j in range(len(curr)):

                    part = curr[:j] + "*" + curr[j+1:]

                    for nei in storage[part]:

                        if nei not in visited:

                            visited.add(nei)
                            q.append(nei)
            length += 1

        return 0