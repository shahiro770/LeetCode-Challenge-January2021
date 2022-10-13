/*
 * Pacific Atlantic Water Flow
 * 
 * August 2022
 * Top 97% (4ms)
 *
 * DFS from the edges. Any overlap from both the atlantic and pacific visited graphs
 * imply that those nodes can have rain fall on them to reach both oceans.
 *
 * Time complexity: O(n*m) as worst case the entire graph is traveresed twice
*/

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ArrayList<List<Integer>> sol = new ArrayList<List<Integer>>();
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] isPacific = new boolean[m][n];
        boolean[][] isAtlantic = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            dfs(heights, isPacific, i, 0, Integer.MIN_VALUE);
            dfs(heights, isAtlantic, i, n - 1, Integer.MIN_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights, isPacific, 0, i, Integer.MIN_VALUE);
            dfs(heights, isAtlantic, m - 1, i, Integer.MIN_VALUE);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isPacific[i][j] == true && isAtlantic[i][j] == true) {
                    ArrayList<Integer> newSol = new ArrayList<Integer>();
                    newSol.add(i);
                    newSol.add(j);
                    sol.add(newSol);
                }
            }
        }
        
        return sol;
    }
    
    public void dfs(int[][] matrix, boolean[][] visited, int x, int y, int height) {
        int m = matrix.length ;
        int n = matrix[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] == true || matrix[x][y] < height) {
            return;
        }
        visited[x][y] = true;
        
        dfs(matrix, visited, x, y + 1, matrix[x][y]);
        dfs(matrix, visited, x, y - 1, matrix[x][y]);
        dfs(matrix, visited, x + 1, y, matrix[x][y]);
        dfs(matrix, visited, x - 1, y, matrix[x][y]);
    }
}