class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        count = 0
        visited = set()
        store = {c:[] for c in range(n)}
        for a,b in edges:
            store[a].append(b)
            store[b].append(a)

        def dfs(node):
            visited.add(node)
            for nei in store[node]:
                if nei not in visited:
                    dfs(nei)

        for node in range(n):
            if node not in visited:
                dfs(node)
                count += 1

        return count