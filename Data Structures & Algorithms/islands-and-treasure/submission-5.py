class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        n = len(grid)
        m = len(grid[0])
        INF = 2147483647
        q = deque()
        Dirs = [(1,0),(-1,0),(0,1),(0,-1)]

        for i in range(n):
            for j in range(m):
                if grid[i][j] == 0:
                    q.append((i,j))

        while q:
            for _ in range(len(q)):
                r,c = q.popleft()
                for dr,dc in Dirs:
                    nr = dr+r
                    nc = dc+c
                    if 0<=nr<n and 0<=nc<m and grid[nr][nc] == INF:
                        grid[nr][nc] = grid[r][c] + 1
                        q.append((nr,nc))