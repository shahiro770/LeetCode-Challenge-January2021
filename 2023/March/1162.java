/*
 * As Far from Land as Possible
 * 
 * Top 87% (7ms)
 * 
 * I went with a BFS solution and got absolutely clapped with a 290ms time at bottom 5%
 * This is the solution for how someone with braincells actually solves this question.
 * 
 * Just read this: https://leetcode.com/problems/as-far-from-land-as-possible/solutions/422691/7ms-dp-solution-with-example-beats-100/?orderBy=most_votes
 * 
 * Time complexity: O(n*m)
 */

class Solution {
    public int maxDistance(int[][] grid) {
        int maxDist = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = Integer.MAX_VALUE;
                    if (i > 0) {
                        grid[i][j] = Math.min(grid[i][j], grid[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        grid[i][j] = Math.min(grid[i][j], grid[i][j - 1] + 1);
                    }
                }
            }
        }
        
        for (int i = grid.length - 1; i > -1; i--) {
            for (int j = grid[0].length - 1; j > -1; j--) {
                if (grid[i][j] == 0) {
                    if (i < grid.length - 1) {
                        grid[i][j] = Math.min(grid[i][j], grid[i + 1][j] + 1);
                    }
                    if (j < grid.length - 1) {
                        grid[i][j] = Math.min(grid[i][j], grid[i][j + 1] + 1);
                    }
                }
                maxDist = Math.max(maxDist, grid[i][j]);
            }
        }
        
        return maxDist == Integer.MAX_VALUE ? -1 : maxDist - 1;
    }
}