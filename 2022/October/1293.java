/*
 * Shortest Path in a Grid with Obstacles Elimination
 *
 * Top 61% (44ms)
 * 
 * BFS all day every day.
 * 
 * Time Complexity: O(n * m) in the event we traverse the whole graph somehow
 */

class Solution {
    public int shortestPath(int[][] grid, int k) {
        Queue<Coord> q = new LinkedList<Coord>();
        int[][][] visited = new int[grid.length][grid[0].length][k + 1];

        q.offer(new Coord(0, 0, k));
        int steps = 0;
        while (q.size() > 0) {
            int currentSize = q.size();
            steps++;
            for (int i = 0; i < currentSize; i++) {
                Coord curr = q.poll();
                if (curr.x < grid.length && curr.y < grid[0].length && curr.x >= 0 && curr.y >= 0) {
                    if (curr.x == grid.length - 1 && curr.y == grid[0].length - 1) {
                        return steps - 1;
                    }
                    if (visited[curr.x][curr.y][curr.k] == 0 && grid[curr.x][curr.y] == 0) {
                        visited[curr.x][curr.y][curr.k] = 1; 
                        q.offer(new Coord(curr.x + 1, curr.y, curr.k));
                        q.offer(new Coord(curr.x -1, curr.y, curr.k));
                        q.offer(new Coord(curr.x, curr.y + 1, curr.k));
                        q.offer(new Coord(curr.x, curr.y - 1, curr.k)); 
                    }
                    else if (visited[curr.x][curr.y][curr.k] == 0 && grid[curr.x][curr.y] == 1 && curr.k > 0) {
                        visited[curr.x][curr.y][curr.k] = 1; 
                        q.offer(new Coord(curr.x + 1, curr.y, curr.k - 1));
                        q.offer(new Coord(curr.x -1, curr.y, curr.k - 1));
                        q.offer(new Coord(curr.x, curr.y + 1, curr.k - 1));
                        q.offer(new Coord(curr.x, curr.y - 1, curr.k - 1)); 
                    }
                }
            }
        }

        return -1;
    }

    private boolean checkVisited(Coord curr, int[][][] visited) {
        return visited[curr.x][curr.y][curr.k] == 1;
    }

    public class Coord {
        int x;
        int y;
        int k;

        public Coord(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }
}