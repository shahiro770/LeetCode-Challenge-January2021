/**
 * Number of islands
 * 
 * August 2022
 * Top 97% (3ms)
 * 
 * Go through each element of the grid. If you see a '1', flood fill adjacent 1s with 0s
 * to count the island and prevent it from being counted again.
 * 
 * Time Complexity: O(n * m) where n and m are the dimensions of the grid
 */ 

class Solution {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        
        // don't mutate the passed in argument
        char [][] gridCopy = new char[grid.length][];
        for(int i = 0; i < grid.length; i++) {
            gridCopy[i] = grid[i].clone();
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    mapIsland(i, j, grid);
                }
            }   
        }
        
        return islandCount;
    }
    
    public void mapIsland(int x, int y, char[][] grid) {
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
            if (x < grid.length - 1) {
                mapIsland(x + 1, y, grid);    
            }
            if (x > 0) {
                 mapIsland(x - 1, y, grid);
            }
            if (y < grid[0].length - 1) {
                mapIsland(x, y + 1, grid);
            }
            if (y > 0) {
                mapIsland(x, y - 1 ,grid);
            }
        }
    } 
}