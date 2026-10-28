class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        num = 0
        n = len(grid)
        m = len(grid[0])
        dir = [(1,0),(0,1),(-1,0),(0,-1)]

        def dfs(r,c):
            grid[r][c] = "0"
            for dr,dc in dir:
                nr = r+dr
                nc = c+dc
                if 0<= nr < n and 0<=nc<m and grid[nr][nc] == "1":
                    dfs(nr,nc)

        for i in range(n):
            for j in range(m):
                if grid[i][j] == "1":
                    num += 1
                    dfs(i,j)
        return num