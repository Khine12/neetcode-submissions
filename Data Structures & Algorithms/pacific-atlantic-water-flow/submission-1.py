class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:

        pacific = set()

        atlantic = set()

        result = []

        rows = len(heights)

        cols = len(heights[0])

        directions = [(1,0),(-1,0),(0,1),(0,-1)]

        def helper(r: int, c: int, visited: set)->'None':

            visited.add((r,c))

            for dr,dc in directions:

                nr = r + dr

                nc = c + dc

                if nr < 0 or nr >= rows or nc < 0 or nc >= cols:
                    continue

                if (nr,nc) in visited:
                    continue

                if heights[nr][nc] >= heights[r][c]:

                    helper(nr,nc,visited)

        for r in range(rows):

            helper(r,0,pacific)

        for c in range(cols):

            helper(0,c,pacific)

        for r in range(rows):

            helper(r,cols-1,atlantic)

        for c in range(cols):

            helper(rows-1,c,atlantic)

        for r in range(rows):

            for c in range(cols):

                if (r,c) in pacific and (r,c) in atlantic:

                    result.append((r,c))

        return result

            