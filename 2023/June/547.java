/*
 * Number of Provinces
 * 
 * Top 51% (2 ms) (bruh)
 * 
 * Simple BFS or DFS (I went with BFS)
 * 
 * Time Complexity: O(n^2) which is just V + E in this case (but need to check for edge existing) 
 */

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provNum = 0;

        Deque<Integer> queue = new ArrayDeque<Integer>();
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == false) {
                provNum++;
                visited[i] = true;

                queue.offer(i);
                while (queue.size() > 0) {
                    int curr = queue.poll();
                    for (int j = 0; j < isConnected[i].length; j++) {
                        if (isConnected[curr][j] == 1 && visited[j] == false) {
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                }
            }
        }

        return provNum;
    }
}