/*
 * Shortest Path with Alternating Colors
 * 
 * Top 93% (4ms)
 * 
 * BFS except there's two quirks:
 * 1) You don't care about visited nodes; you care about visited edges. Since the fastest route to a node
 * from the 0th node to node will be the path taken when we first arrive at that node, you can effectively
 * remove/mark as visited such edges
 * 2) Parallel edges have a big quirk in this problem. A red/blue parallel edge from 0 means you have two possible
 * for a given node and need to traverse them seperately (another reason why visiting by node doesn't work).
 * 
 * Time complexity: O(v * e )
 */

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ans = new int[n];
        
        for (int i = 0; i < ans.length; i++) {
            ans[i] = -1;
        }

        int[][] adjList = new int [n][n];

        for (int i = 0; i < redEdges.length; i++) {
            adjList[redEdges[i][0]][redEdges[i][1]] += 1;
        }

        // Notice this makes the value = 3 if there's a parallel red/blue edge
        // This question doesn't seem to allow for more than 2 parallel edges (thank god),
        // or else this would fail
        for (int i = 0; i < blueEdges.length; i++) {
            adjList[blueEdges[i][0]][blueEdges[i][1]] += 2;
        }

        /*
            [0] = node
            [1] = previous edge colour (0 = start, 1 = red, 2 = blue)
        */
        Deque<int[]> queue = new ArrayDeque<int[]>();

        ans[0] = 0;
        int depth = 1;
        for (int i = 1; i < n; i++) {
            if (adjList[0][i] == 1) {
                queue.offer(new int[] {i, 1});
                adjList[0][i] -= 1;
                ans[i] = depth;
            }
            else if (adjList[0][i] == 2) {
                queue.offer(new int[] {i, 2});
                adjList[0][i] -= 2;
                ans[i] = depth;
            }
            else if (adjList[0][i] == 3) {
                queue.offer(new int[] {i, 1});
                queue.offer(new int[] {i, 2});
                adjList[0][i] -= 3;
                ans[i] = depth;
            }
        }
        depth++;

        while (queue.size() > 0) {
            int queueSize = queue.size();
            for (int j = 0; j < queueSize; j++) {
                int[] node = queue.poll();
                int[] adj = adjList[node[0]];
                for (int i = 0; i < n; i++) {
                    if (adj[i] > 0) {
                        if ((adj[i] == 1 && node[1] == 2)
                        || (adj[i] == 2 && node[1] == 1)) {
                            ans[i] = ans[i] ==  -1 ? depth: Math.min(ans[i], depth);
                            queue.offer(new int[] {i, adj[i]});
                            adj[i] = 0;
                        }
                        else if (adjList[node[0]][i] == 3) {
                            ans[i] = ans[i] ==  -1 ? depth: Math.min(ans[i], depth);
                            if (node[1] == 1) {
                                adj[i] -= 2;
                                queue.offer(new int[] {i, 2});
                            }
                            else {
                                adj[i] -= 1;
                                queue.offer(new int[] {i, 1});
                            }
                        }
                    }
                }
            }
            depth++;
        }

        return ans;
    }
}