class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        
        if not heights:
            return []

        rows = len(heights)
        cols = len(heights[0])

        pacific = set()
        atlantic = set()

        directions = [(-1,0),(1,0),(0,-1),(0,1)]

        def dfs (r,c,visited,pre_height):

            if 0<= r < rows and 0 <= c < cols and (r,c) not in visited and heights[r][c] >= pre_height:

                visited.add((r,c))

                pre_height = heights[r][c]

                for dr,dc in directions:

                    nr,nc = r+dr , c+dc

                    dfs(nr,nc,visited,pre_height)

        for c in range(cols):

            dfs(0,c,pacific,heights[0][c])

            dfs(rows-1,c,atlantic, heights[rows-1][c])

        for r in range(rows):

            dfs(r,0,pacific,heights[r][0])
            
            dfs(r,cols-1,atlantic, heights[r][cols-1])

        result = []

        for r in range(rows):

            for c in range(cols):

                if (r,c) in pacific and (r,c) in atlantic:

                    result.append([r,c])

        return result