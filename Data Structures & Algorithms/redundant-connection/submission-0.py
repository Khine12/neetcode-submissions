class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        adj = {i:[] for i in range(1,len(edges)+1)}

        def dfs(curr,target,visited):

            if curr == target:
                return True

            visited.add(curr)

            for nei in adj[curr]:
                if nei not in visited:
                    if dfs(nei,target,visited):
                        return True

            return False

        for a,b in edges:

            if dfs(a,b,set()):
                return [a,b]

            adj[a].append(b)
            adj[b].append(a)