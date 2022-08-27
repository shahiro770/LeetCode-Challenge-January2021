/**
 * May 2021 Day 12
 * 
 * Store the cumulative sums for each square from 0,0 to a given index. From there computing
 * any square in the matrix just needs a bit of thinking to delete the sums that are added or subtracted
 * twice in the calculation process.
 * 
 * Time Complexity O(mn) to construct the dp matrix
 * 
 *
*/

class NumMatrix {
    int[][] dp;
    
    public NumMatrix(int[][] matrix) {
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                dp[i][j] = matrix[i - 1][j - 1] + dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */