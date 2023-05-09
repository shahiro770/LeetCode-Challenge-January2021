/*
 * Minimum Path Sum
 *
 * Top 82% (2ms)
 *
 * Top down dp solution. Start from the top left and iterate through the columns. Each cell
 * chooses the min of the value that is to the left or above it.
 * 
 * Time Complexity: O(n*m)
 */

class Solution {
    public int minPathSum(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (row == 0 && col != 0) {
                    grid[row][col] = grid[row][col] + grid[row][col - 1];
                }
                else if (col == 0 && row != 0) { 
                    grid[row][col] = grid[row][col] + grid[row - 1][col];
                }
                else if (row != 0 && col != 0) {
                    grid[row][col] = grid[row][col] + Math.min(grid[row - 1][col], grid[row][col - 1]);
                }
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}