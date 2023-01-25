/*
 * Snakes and Ladders
 * 
 * Top 99% (3ms)
 * 
 * A second visited array is helpful as you can think about visiting a square in two ways (through a natural roll or through a 
 * snake/ladder). Since you can't chain snakes/ladders, this way visiting may matter in edge cases where you snake to a snake square
 * but don't chain snake, allowing you to reach a higher square later on.
 * 
 * Also flatten the 2d grid to not have to think about the math (especially with the grid orientation being confusing).
 * 
 * Time Complexity: O(V + E)
 */

class Solution {
    public int snakesAndLadders(int[][] board) {
        int[] flatBoard = new int[board.length * board.length];
        boolean[] visited = new boolean[board.length * board.length];
        boolean[] visitedSL = new boolean[board.length * board.length];

        // flatten the board to make the question easier
        int pos = 0;
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board.length; j++) {
                flatBoard[pos] = board[i][j];
                pos++;
            }
            i--;
            if (i >= 0) {
                for (int j = board.length - 1; j >= 0; j--) {
                    flatBoard[pos] = board[i][j];
                    pos++;
                }
            }
        }

        // initialization
        Deque<Integer> q = new ArrayDeque<Integer>();
        q.offer(0);
        visited[0] = true;
        int depth = 1;
        
        while (q.size() > 0) {
            int depthCount = q.size();
            for (int i = 0; i < depthCount; i++) {
                int candidate = q.poll();

                for (int j = 1; j <= 6; j++) {
                    if (j + candidate < flatBoard.length && visited[j + candidate] == false) {
                        visited[j + candidate] = true;
                        if (j + candidate == flatBoard.length - 1) {
                            return depth;
                        }
                        else if (flatBoard[j + candidate] != -1) {
                            if (visitedSL[flatBoard[j + candidate] - 1] == false) {
                                if (flatBoard[j + candidate] - 1 == flatBoard.length - 1) {
                                    return depth;
                                }
                                visitedSL[flatBoard[j + candidate] - 1] = true;
                                q.offer(flatBoard[j + candidate] - 1);
                            }
                        }
                        else {
                            q.offer(j + candidate);
                        }
                    }
                }
            }
            depth++;
        }

        return -1;
    }
}
