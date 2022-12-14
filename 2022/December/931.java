/*
 * Minimum Falling Path Sum
 * 
 * Top 74% (4ms)
 *
 * Very straightforward DP. For the above row, take the smallest value of the 2 or 3 values
 * that connect with the current matrix square (direct above or diagonals).
 * 
 * Note the edge cases where you have a 1x1 or 2x2 matrix
 * 
 * Time Complexity: O(n * n) where n is the matrix length
 */

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) {
                    if (matrix[0].length == 1) {    // 1 column matrix can only add directly above
                        dp[i][j] = dp[i - 1][j] + matrix[i][j];
                    }
                    else { 
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                    }
                }
                else if (j == matrix[0].length - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
                }
                else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i - 1][j + 1]) + matrix[i][j];
                }
            }
        }

        int sol = Integer.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            if (dp[matrix.length - 1][i] < sol) {
                sol = dp[matrix.length - 1][i];
            }
        }

        return sol;
    }
}