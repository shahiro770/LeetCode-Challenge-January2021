/**
 * Where Will the Ball Fall
 * 
 * Top 76% (2ms)
 * 
 * Only thing to keep in mind is that the the ball will alternate between rolling to
 * an adjacent spot and falling down with how the ball can be above or below a pipe
 * on a given square.
 * 
 * Time Complexity: O(n * m) if it somehow has to visit every square
 * */

class Solution {
    public int[] findBall(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] sol = new int[cols];

        for (int i = 0; i < cols; i++) {
            int x = 0;
            int y = i;
            boolean isAbove = true;
            while (true) {
                if (isAbove) {
                    if (grid[x][y] == -1 && (y > 0 && grid[x][y - 1] == -1)) {
                        y -= 1;
                        isAbove = false;
                    }
                    else if (grid[x][y] == 1 && (y < cols - 1 && grid[x][y + 1] == 1)) {
                        y += 1;
                        isAbove = false;
                    }
                    else {
                        sol[i] = -1;
                        break;
                    }
                }
                else {  // below the line on the square/ falling to the next row
                    if (x == rows - 1) {
                        sol[i] = y;
                        break;
                    }
                    else {
                        x += 1;
                        isAbove = true;
                    }
                }
            }
        }

        return sol;
    }
}