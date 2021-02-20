/**
 * Feb 2021 Day 13
 * Top 100% but at what cost
 * 
 * This question is big dumb cause leetcode wants some baboon optimizations to not time out.
 * 1) Find a way to store both coords in the same number
 *      Super minor, but really clean on the space efficiency (no need for a pair or private class)
 *      Cool trick is using bit shifts x + (y << 7) will make x take up first 7 bits and y take last 7
 *          This only works cause restrictions (in this case x and y are at most 200, which is 7 bits, so an int of 16 bits can fit both)
 *      To get bits off, make a 1111111 bit mask and & it for x, then shift right 7 times for y
 * 2) Reduce checks as much as possible
 *      The max and mins in my loops are huge important; they prevent even checking if we're in range for each cell
 * 
 * Effieicny is O(V + E) where V is the number of verts and E is the number of edges
 */

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Deque<Integer> visited = new ArrayDeque<Integer>();
        
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }
        
        visited.add((0 + (0 << 7));
        grid[0][0] = 1;
        int curr;
        int x;
        int y;
        int n = grid.length - 1;
        int steps = 1;
        
        while (visited.size() > 0) {
            int size = visited.size();
            for (int i = 0; i < size; i++) {
                curr = visited.poll();
                x = curr & ((1 << 7) - 1);
                y = curr >> 7;
                
                if (x == grid.length - 1 && y == grid[0].length - 1) {
                    return steps;
                }
                for (int a = Math.max(x - 1, 0); a <= Math.min(x + 1, n); a++) {    // x coordinates
                    for (int b = Math.max(y - 1, 0); b <= Math.min(y + 1, n); b++) { // y coordinates
                        if (grid[a][b] == 0) {
                            grid[a][b] = 1;
                            visited.add(a + (b << 7));
                        }
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}