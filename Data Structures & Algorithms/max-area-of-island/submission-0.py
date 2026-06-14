class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:

        if not grid:
            return 0

        rows = len(grid)
        cols = len(grid[0])

        max_area = 0

        def helper(r: int, c: int)->int:

            if r < 0 or r >= rows or c < 0 or c >= cols:
                return 0

            if grid[r][c] == 0:
                return 0

            grid[r][c] = 0

            return 1 + helper(r+1,c) + helper(r-1,c) + helper(r,c+1) + helper(r,c-1)

        
        for i in range(rows):
            for j in range(cols):

                if grid[i][j] == 1:
                    
                    max_area = max(max_area,helper(i,j))

        return max_area