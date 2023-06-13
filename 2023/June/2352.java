/*
 * Equal Row and Column Pairs
 *
 * Top 94% (10ms)
 *  
 * Fastest way to do this question is covert the columns into rows that can easily be copmared
 * via Arrays.equals(). The end result is still O(n^3), but hey I learned a.equals(b) for arrays
 * compares memory addresses and you want to use Arrays.equals() to compare array contents.
 * 
 * Time Complexity: O(n^3)
 * 
 */

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int ans = 0;

        int[][] gridTransposed = new int[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                gridTransposed[i][j] = grid[j][i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Arrays.equals(grid[i], gridTransposed[j])) {
                    ans++;
                }
            }
        }

        return ans;
    }
}