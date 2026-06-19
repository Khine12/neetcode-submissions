class Solution:
    def solve(self, board: List[List[str]]) -> None:
        
        rows = len(board)
        cols = len(board[0])

        for r in range(rows):

            for c in range(cols):

                if r == 0 or r == rows-1 or c == 0 or c == cols-1:

                    board[r][c] = board[r][c]

                elif 0 < r < rows-1 and 0 < c < cols-1:

                    board[r][c] = "X"