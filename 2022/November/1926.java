/*
 * Nearest Exit from Entrance in Maze
 * 
 * Top 99% (5ms)
 * 
 * Basic BFS question. Just remember, always mark visited when enqueing, never when
 * dequeuing, since otherwise the same spot may be enqueue'd several times before its finally visited,
 * greatly increasing your time complexity.
 * 
 * Time Complexity: O(n + m)
 * */

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Deque<int[]> queue = new ArrayDeque<int[]>();

        maze[entrance[0]][entrance[1]] = '+';
        int dist = 0;

        queue.offer(entrance);
        while (queue.size() > 0) {
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                int[] curr = queue.poll();
                
                if ((curr[0] != entrance[0] || curr[1] != entrance[1]) && (curr[0] == 0 
                || curr[0] == maze.length - 1 || curr[1] == 0 || curr[1] == maze[0].length - 1)) {
                    return dist;
                }

                if (curr[0] + 1 < maze.length && maze[curr[0] + 1][curr[1]] == '.') {
                    maze[curr[0] + 1][curr[1]] = '+';
                    queue.offer(new int[]{curr[0] + 1, curr[1]});
                }
                if (curr[0] - 1 >= 0 && maze[curr[0] - 1][curr[1]] == '.') {
                    maze[curr[0] - 1][curr[1]] = '+';
                    queue.offer(new int[]{curr[0] - 1, curr[1]});
                }
                if (curr[1] + 1 < maze[0].length && maze[curr[0]][curr[1] + 1] == '.') {
                    maze[curr[0]][curr[1] + 1] = '+';
                    queue.offer(new int[]{curr[0], curr[1] + 1});
                }
                if (curr[1] - 1 >= 0 && maze[curr[0]][curr[1] - 1] == '.') {
                    maze[curr[0]][curr[1] - 1] = '+';
                    queue.offer(new int[]{curr[0], curr[1] - 1});
                }
            }
            dist++;
        }

        return -1;
    }
}