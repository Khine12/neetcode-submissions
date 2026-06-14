class Solution {

    private static final int INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        
        int rows = grid.length;

        int cols = grid[0].length;

        Deque<int[]> q = new ArrayDeque<>();

        for(int r=0; r < rows; r++){

            for(int c=0; c < cols; c++){

                if(grid[r][c] == 0){

                    q.offerLast(new int[]{r,c});
                }
            }
        }

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){

            int[] cur = q.pollFirst();

            int r = cur[0]; 

            int c = cur[1];

            for(int[] d : directions){

                int nr = r + d[0];

                int nc = c + d[1];

                if(nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

                if(grid[nr][nc] != INF) continue;

                grid[nr][nc] = grid[r][c] + 1;

                q.offerLast(new int[]{nr,nc});
            }


        }
    }

    
}
