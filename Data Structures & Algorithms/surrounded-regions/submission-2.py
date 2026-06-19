class Solution:
    def solve(self, board: List[List[str]]) -> None:
        
        rows = len(board)
        cols = len(board[0])
        region = set()
        direction = [(-1,0),(1,0),(0,-1),(0,1)]

        def dfs(r,c,collection):

            if 0 <= r < rows and 0 <= c < cols and (r,c) not in region and board[r][c] == "O":

                collection.add((r,c))

                for dr,dc in direction:

                    dfs(r + dr, c + dc,collection)

        for c in range(cols):

            dfs(0,c,region)
            dfs(rows-1,c,region)

        for r in range(rows):

            dfs(r,0,region)
            dfs(r,cols-1,region)
            

        for r in range(rows):

            for c in range(cols):

                if (r,c) not in region and board[r][c] == "O":

                    board[r][c] ="X"