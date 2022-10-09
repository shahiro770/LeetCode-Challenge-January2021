/**
 * Valid Sudoku
 *
 * October 2022
 * Top 97% (2ms)  
 * 
 * Time complexity: O(1) technically since the board is always a 9x9
 * */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        return horizontalTest(board) && verticalTest(board) && boxTest(board);
    }

    public boolean horizontalTest(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] counts = new int[9];
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    counts[board[i][j] - '1']++;
                    if (counts[board[i][j] - '1'] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean verticalTest(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            int[] counts = new int[9];
            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i] != '.') {
                    counts[board[j][i] - '1']++;
                    if (counts[board[j][i] - '1'] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean boxTest(char[][] board) {
        int y = 0;
        for (int h = 0; h < 3; h++) {
            int x = 0;
            for (int i = 0; i < 3; i++) {
                int[] counts = new int[9];
                for (int j = x; j < x + 3; j++) {
                    for (int k = y; k < y + 3; k++) {
                        if (board[j][k] != '.') {
                            counts[board[j][k] - '1']++;
                            if (counts[board[j][k] - '1'] > 1) {
                                return false;
                            }
                        }
                    }
                }
                x += 3;
            }
            y += 3;
        }

        return true;
    }
}