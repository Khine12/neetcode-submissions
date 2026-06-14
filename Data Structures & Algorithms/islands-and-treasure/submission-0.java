class Solution {

    private static final INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        
        int rows = grid.length;

        int cols = grid[0].length;

        Deque<int[]> q = new ArrayDeque<>();

        for(int r; r < rows; r++){

            for(int c; c < cols; c++){

                if(grid[r][c] == 0){

                    q.offerLast(new int[]{r,c});
                }
            }
        }

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty){

            int[] cur = q.pollFirst();

            for(int[] d : directions){

                int nr = cur[0] + d[0];

                int nc = cur[1] + d[1];

                if(nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

                if(grid[nr][nc] != INF) continue;

                grid[nr][nc] = grid[r][c] + 1;

                q.offerLast(new int[]{nr,nc});
            }


        }
    }

    
}
