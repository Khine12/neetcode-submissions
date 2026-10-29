class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        n = len(heights)
        m = len(heights[0])
        result = []
        pacific = set()
        atlantic = set()
        Dirs = [(1,0),(-1,0),(0,1),(0,-1)]

        def dfs(r,c,visited,pre_height):
            
            if 0<=r<n and 0<=c<m and (r,c) not in visited and heights[r][c] >= pre_height:
                visited.add((r,c))
                for dr,dc in Dirs:
                    nr = dr+r
                    nc = dc+c
                    dfs(nr,nc,visited,heights[r][c])

        for c in range(m):
            dfs(0,c,pacific,heights[0][c])
            dfs(n-1,c,atlantic,heights[n-1][c])

        for r in range(n):
            dfs(r,0,pacific,heights[r][0])
            dfs(r,m-1,atlantic,heights[r][m-1])

        for i in range(n):
            for j in range(m):
                if (i,j) in pacific and (i,j) in atlantic:
                    result.append([i,j])

        return result