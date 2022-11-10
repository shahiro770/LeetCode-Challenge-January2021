/*
 * Search a 2D Matrix
 *
 * Top 100% (0ms) 
 * 
 * First narrow down the row, then the column
 * 
 * Time Complexity: O(lg(nm))
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        int row = 0;
        int col = 0;

        while (left <= right) {
            row = (left + right) / 2;

            if (matrix[row][0] == target) {
                return true;
            }
            // stop if the value must be in the row and move on to column search
            if (matrix[row][0] < target && matrix[row][matrix[0].length - 1] >= target) {
                break;
            }
            if (matrix[row][0] > target) {
                right = row - 1;
            }
            else {
                left = row + 1;
            }
        }

        left = 0;
        right = matrix[0].length - 1;

        while (left <= right) {
            col = (left + right) / 2;

            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                right = col - 1;
            }
            else {
                left = col + 1;
            }
        }

        return false;
    }
}

/*
    mid = 7
    row length = 4;
    col length = 3
    7 % 4 = 3
    7 % 3 = 1
*/