class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:

        rows = len(grid)

        cols = len(grid[0])

        fresh = 0

        q = deque()

        for r in range(rows):

            for c in range(cols):

                if grid[r][c] == 2:

                    q.append((r,c))

                elif grid[r][c] == 1:

                    fresh += 1

        directions = [(1,0),(-1,0),(0,1),(0,-1)]

        minutes = 0

        while q and fresh > 0:

            size = len(q)

            for i in range(size):

                r,c = q.popleft()

                for dr,dc in directions:

                    nr = r + dr
                    nc = c + dc

                    if nr < 0 or nr >= rows or nc < 0 or nc >= cols:
                        continue

                    if grid[nr][nc] != 1:
                        continue

                    grid[nr][nc] = 2

                    fresh -=1

                    q.append((nr,nc))

            minutes += 1

        return minutes if fresh == 0 else -1


        