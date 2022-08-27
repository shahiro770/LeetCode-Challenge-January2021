/**
 * Aug 2022 Day 1
 * 
 * Top 96% 
 * 
 * Simple DP. The number of ways for the robot to reach the current grid cell will be equal to the number
 * of ways to reach the cell above it + the number of ways to reach the cell to its left 
 * (since it can only traverse down and right).
 * 
 * There is an O(1) solution but I need to learn combinatorics (you can see a pattern matching pascal's triangle
 * if you draw out the DP solution)
 * 
 * Time Complexity: O(m + n + mn) < O(mn) because we visit each cell in the grid to get our final answer
 * 
 * */

class Solution {
    int totalPaths = 0;
    
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            grid[i][0] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            grid[0][i] = 1;
        }
        
        for (int i = 1 ; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }
        
        return grid[m - 1][n - 1];
    }
}