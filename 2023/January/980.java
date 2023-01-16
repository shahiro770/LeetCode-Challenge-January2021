/*
 * Unique Paths III
 * 
 * Top 100% (0ms)
 * 
 * Unironically easiest leetcode hard I've ever done. High chance this question has really easy test cases given
 * the possibly time complexity being like n^3.
 * 
 * DFS and backtrack all day.
 * 
 * Time Complexity: O((V + E)^3)?? since three directions need to be tried from the square we just entered at most
 */

 class Solution {
    int pathTotal;

    public int uniquePathsIII(int[][] grid) {
        pathTotal = 0;

        int startX = 0;
        int startY = 0;
        int emptySquares = 1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
                else if (grid[i][j] == 0) {
                    emptySquares++;
                }
            }
        }

        dfs(startX, startY, grid, emptySquares);

        return pathTotal;
    }

    private void dfs(int x, int y, int[][]grid, int emptySquares) {
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
        && grid[x][y] != -1) {
            if (grid[x][y] == 2) {
                if (emptySquares == 0) {
                    pathTotal++;
                }
            }
            else {
                grid[x][y] = -1;
                emptySquares--;

                dfs(x + 1, y, grid, emptySquares);
                dfs(x - 1, y, grid, emptySquares);
                dfs(x, y - 1, grid, emptySquares);
                dfs(x, y + 1, grid, emptySquares);
                grid[x][y] = 0;
            }
        }
    }
}