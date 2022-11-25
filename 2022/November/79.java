/*
 * Word Search
 * 
 * Top 51% (187ms)
 * 
 * The only catch is that you need to avoid marking a position as visited
 * prior to visiting it (which is why dfs needs to be done for this problem and not bfs).
 * 
 * Time Complexity: O(m*n*w), where w is the length of the word
 * */

class Solution {
    int[][] dir = new int[][]{ {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    boolean ans = false;

    public boolean exist(char[][] board, String word) {
         boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    Deque<int[]> stack = new ArrayDeque<int[]>();
                    dfs(word, new int[]{i, j}, 0, board, visited);
                }
            }
        }

        return ans;
    }

    public void dfs(String word, int[] coord, int index, char[][] board, boolean[][] visited) {
        visited[coord[0]][coord[1]] = true;
        if (index == word.length() - 1) {
            ans = true;
        }

        for (int j = 0; j < dir.length; j++) {
            int[] newCoord = new int[] {coord[0] + dir[j][0], coord[1] + dir[j][1]};
            if (newCoord[0] < board.length && newCoord[0] >= 0 
            && newCoord[1] < board[0].length && newCoord[1] >= 0 
            && index + 1 < word.length()
            && board[newCoord[0]][newCoord[1]] == word.charAt(index + 1)
            && visited[newCoord[0]][newCoord[1]] == false && ans == false) {
                dfs(word, newCoord, index + 1, board, visited);
            }
        }
             
        visited[coord[0]][coord[1]] = false;
    }
}