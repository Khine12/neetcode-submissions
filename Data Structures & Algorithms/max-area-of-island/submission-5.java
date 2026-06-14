class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int rows = grid.length;

        int cols = grid[0].length;

        int max_area = 0;

        for(int i; i < rows; i++){

            for(int j; j < cols; j++){

                if(grid[i][j] == 1){

                    area(grid,i,j);

                    max_area = Math.max(max_area,area(grid,i,j));
                }
            }
        }
        return max_area;
    }

    private int area(int[][] grid,int r,int c){

        int rows = grid.length;

        int cols = grid[0].length;

        if(r < 0 || r >= rows || c < 0 || c >= cols){

            return 0;
        }

        if(grid[r][c] == 0) return 0;

        grid[r][c] = 0;

        return 1 + area(r+1,c) + area(r-1,c) + area(r,c+1) + area(r,c-1);
    }
}
