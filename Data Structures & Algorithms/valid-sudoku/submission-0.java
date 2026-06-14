class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Set<Character>[] rows = new HashSet[9];

        Set<Character>[] columns = new HashSet[9];

        Set<Character>[] boxes = new HashSet[9];

        for(int i=0; i<9; i++){

            rows[i] = new HashSet<>();

            columns[i] = new HashSet<>();

            boxes[i] = new HashSet<>();
        }

        for(int r = 0; r<9; r++){

            for(int c=0; c<9; c++){

                char val = board[r][c];

                if(val == '.') continue;

                int box = (r/3) *3 + (c/3);

                if(rows[r].contains(val) || columns[c].contains(val) || boxes[box].contains(val)){

                    return false;
                }

                rows[r].add(val);

                columns[c].add(val);

                boxes[box].add(val);

            }
        }

        return true;

    }
}
