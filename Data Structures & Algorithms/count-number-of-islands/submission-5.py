class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        if not grid:
            return 0

        count = 0

        rows = len(grid)
        cols = len(grid[0])

        def dbf(r,c):

            if r < 0 or r >= rows or c < 0 or c >= cols or grid[r][c] == '0':

                return

            grid[r][c] = '0'

            dbf(r+1,c)
            dbf(r-1,c)
            dbf(r,c+1)
            dbf(r,c-1)

        for r in range(rows):

            for c in range(cols):

                if grid[r][c] == '1':

                    count = count + 1

                    dbf(r,c)

        return count