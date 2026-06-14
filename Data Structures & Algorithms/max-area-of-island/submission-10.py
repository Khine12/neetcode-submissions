class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        
        if not grid:
            return 0

        rows = len(grid)
        cols = len(grid[0])

        max_area = 0

        def dbf(r,c):

            if r < 0 or r >= rows or c < 0 or c >= cols or grid[r][c] == 0:

                return 0

            grid[r][c] = 0

            return (1 + dbf(r+1,c) + dbf(r-1,c) + dbf(r,c+1) + dbf(r,c-1))

        for r in range(rows):

            for c in range(cols):

                if grid[r][c] == 1:

                    max_area = max(max_area,dbf(r,c))

        return max_area