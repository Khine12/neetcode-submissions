class Solution {

    private boolean[][] pacific;

    private boolean[][] atlantic;

    private int[][] heights;

    private int rows;

    private int cols;

    private final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        this.heights = heights;

        rows = heights.length;

        cols = heights[0].length;

        pacific = new boolean[rows][cols];

        atlantic = new boolean[rows][cols];

        List<List<Integer>> result = new ArrayList<>();

        for(int r=0; r < rows; r++){

            helper(r,0,pacific);
        }
        for(int c=0; c < cols; c++){

            helper(0,c,pacific);
        }

        for(int r= 0; r < rows; r++){

            helper(r,cols-1,atlantic);
        }

        for(int c= 0; c < cols; c++){

            helper(rows-1,c,atlantic);
        }

        for(int r=0; r < rows; r++){

            for(int c=0; c < cols; c++){

                if(pacific[r][c] && atlantic[r][c]){

                    result.add(Arrays.asList(r,c));
                }
            }
        }
        return result;
    }

    private void helper(int r, int c, boolean[][] visited){

        if(visited[r][c]) return;

        visited[r][c] = true;

        for(int[] d : directions){

            int nr = r + d[0];

            int nc = c + d[1];

            if(nr < 0 || nr >= rows || nc < 0 || nc >= cols){

                continue;
            }

            if(heights[nr][nc] >= heights[r][c]){

                helper(nr,nc,visited);
            }
        }
    }
}
