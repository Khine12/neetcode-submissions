class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        n = len(grid)
        m = len(grid[0])
        max_area = 0
        Dir = [(1,0),(-1,0),(0,1),(0,-1)]

        def dfs(r,c):
            grid[r][c] = 0
            area = 1
            for dr,dc in Dir:
                nr = r+dr
                nc = c+dc
                if 0<=nr<n and 0<=nc<m and grid[nr][nc] == 1:
                    area += dfs(nr,nc)
            return area

        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    max_area = max(max_area,dfs(i,j))
        return max_area