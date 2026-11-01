class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        result = []
        size = 0
        end = 0
        store = {}
        for i in range(len(s)):
            store[s[i]]=i
        for i in range(len(s)):
            size += 1
            end = max(end,store[s[i]])
            if i==end:
                result.append(size)
                size = 0
        return result