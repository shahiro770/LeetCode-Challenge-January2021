/*
 * Count Negative Numbers in a Sorted Matrix
 * 
 * Top 100% (0ms)
 * 
 * There is an m + n solution that is less obvious. Since the entire 2d array is sorted
 * in non-increasing order, given an array that looks like this
 * 
 * +++++
 * +++--
 * ++---
 * -----
 * 
 * Algorithm
 * 1) Start at the bottom left corner,Keep track of the row and column index 
        1.1) row = m - 1, c = 0
 * 2) If its negative, add n - c and move to the n above row
 * 3) Move right until you see a negative (c++)
 * 4) Repeat 2) and 3)
 * 5) At most, you will do n + m operations
 *
 * This algorithm requires you to start at the bottom however, as you can't 
 * guarantee the number going column-wise downwards on the array will not be negative/positive
 * based on the above value (unlike going upwards)
 * 
 * Time Complexity: O(m * n)
 */

class Solution {
    public int countNegatives(int[][] grid) {
        int negCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    negCount += grid[i].length - j; // - 1 + 1
                    break;
                }
            }
        }

        return negCount;
    }
}