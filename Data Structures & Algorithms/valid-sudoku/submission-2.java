class Solution {

    public boolean isValidSudoku(char[][] board) {
       return  sudokuSolver(board, 0, 0);
    }

    public boolean sudokuSolver(char[][] board, int row, int col) {

        if (row == 9) {
            return true;
        }

        int nextRow = row;
        int nextCol = col + 1;

        if (col+1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

       
        if (board[row][col] != '.') {
           if(isSafe(board,row,col,board[row][col])) return sudokuSolver(board,nextRow,nextCol);
           else return false;
        }
        return sudokuSolver(board,nextRow,nextCol);
 
    }

    public boolean isSafe(char[][] board, int row, int col, char digit) {

        // Check row
        for (int i = 0; i < 9; i++) {
            if(i==col) continue;
            if (board[row][i] == digit) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
              if(i==row) continue;
            if (board[i][col] == digit) {
                return false;
            }
        }

        // Check 3x3 grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                   if(i==row || j==col) continue;
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }
}