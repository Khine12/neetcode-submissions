class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        
        adj = {c: [] for c in range(n)}

        for a,b in edges:

            adj[a].append(b)
            adj[b].append(a)

        visited = set()
        count = 0

        def dfs(current):

            visited.add(current)

            for nei in adj[current]:

                if nei not in visited:

                    dfs(nei)

        for node in range(n):

            if node not in visited:

                dfs(node)
                count += 1
        
        return count