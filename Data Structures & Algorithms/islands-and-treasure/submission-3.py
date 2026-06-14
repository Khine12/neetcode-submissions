class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:

        INF = 2147483647

        q = deque()
        
        rows = len(grid)

        cols = len(grid[0])

        for r in range(rows):

            for c in range(cols):

                if grid[r][c] == 0:

                    q.append((r,c))

        directions = [(1,0),(-1,0),(0,1),(0,-1)]

        while q:
            r,c = q.popleft()

            for dr,dc in directions:

                nr = r + dr
                nc = c + dc

                if nr < 0 or nr >= rows or nc < 0 or nc >= cols:
                    continue

                if grid[nr][nc] != INF:
                    continue

                grid[nr][nc] = grid[r][c] + 1

                q.append((nr,nc))

            

