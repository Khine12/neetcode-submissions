class Solution {
    public int orangesRotting(int[][] grid) {

        Deque<int[]> q = new ArrayDeque<>();
        
        int rows = grid.length;

        int cols = grid[0].length;

        int fresh = 0;

        for(int r=0; r < rows; r++){

            for(int c=0; c < cols; c++){

                if(grid[r][c] == 2){

                    q.offerLast(new int[]{r,c});
                }
                else if(grid[r][c] == 1){

                    fresh++;
                }
            }
        }

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        int minutes = 0;

        while(!q.isEmpty() && fresh >0){

            int size = q.size();

            for(int i=0; i < size; i++){

                int[] cur = q.pollFirst();

                int r = cur[0];

                int c = cur[1];
   
                for(int[] d : directions){

                    int nr = r + d[0];

                    int nc = c + d[1];

                    if(nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

                    if(grid[nr][nc] != 1) continue;

                    grid[nr][nc] = 2;

                    fresh--;
   
                    q.offerLast(new int[]{nr,nc});
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;

    }
}
