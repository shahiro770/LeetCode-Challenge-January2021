/**
 * Garbage tier path finding
 */

import java.util.*;

class Day26 {
    public int minimumEffortPath(int[][] heights) {
        List<int[]> queue = new ArrayList<int[]>();
        
        int effort = -1;
        int m = heights.length - 1;
        int n = heights[0].length - 1;
        
        int[][] lowestEffort = new int[heights.length][heights[0].length];
        for (int i = 0; i < lowestEffort.length; i++) {
            Arrays.fill(lowestEffort[i], -1);            
        }
        
        queue.add(new int[] {0, 0});
        lowestEffort[0][0] = 0;
        
        while (queue.isEmpty() == false) {
            int[] pos = queue.remove(0);
            
            if (pos[0] > 0) {
                effort = Math.max(Math.abs(heights[pos[0] - 1][pos[1]] - heights[pos[0]][pos[1]]),                     lowestEffort[pos[0]][pos[1]]);
                if (lowestEffort[pos[0] - 1][pos[1]] == -1 || 
                               lowestEffort[pos[0] - 1][pos[1]] > effort) {
                    lowestEffort[pos[0] - 1][pos[1]] = effort;
                    queue.add(new int[] {pos[0] - 1, pos[1]});
                }
            }

            if (pos[0] < m) {
                effort = Math.max(Math.abs(heights[pos[0] + 1][pos[1]] - heights[pos[0]][pos[1]]),
                lowestEffort[pos[0]][pos[1]]);
                if (lowestEffort[pos[0] + 1][pos[1]] == -1 || 
                               lowestEffort[pos[0] + 1][pos[1]] > effort) {
                    lowestEffort[pos[0] + 1][pos[1]] = effort;
                    queue.add(new int[] {pos[0] + 1, pos[1]});
                }
            }

            if (pos[1] > 0) {
                effort = Math.max(Math.abs(heights[pos[0]][pos[1] - 1] - heights[pos[0]][pos[1]]),
                lowestEffort[pos[0]][pos[1]]);
                if (lowestEffort[pos[0]][pos[1] - 1] == -1 || 
                               lowestEffort[pos[0]][pos[1] - 1] > effort) {
                    lowestEffort[pos[0]][pos[1] - 1] = effort;
                    queue.add(new int[] {pos[0], pos[1] - 1});
                }
            }

            if (pos[1] < n) {
                effort = Math.max(Math.abs(heights[pos[0]][pos[1] + 1] - heights[pos[0]][pos[1]]),
                lowestEffort[pos[0]][pos[1]]);
                if (lowestEffort[pos[0]][pos[1] + 1] == -1 || 
                               lowestEffort[pos[0]][pos[1] + 1] > effort) {
                    lowestEffort[pos[0]][pos[1] + 1] = effort;
                    queue.add(new int[] {pos[0], pos[1] + 1});
                }
            }
        }
        
        return lowestEffort[m][n];
    }
}