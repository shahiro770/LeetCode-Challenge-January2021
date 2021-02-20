/**
 * Feb 2021 Day 14
 * Top 71.99% because 1ms isn't good enough
 * 
 * BFS each node with an attempt to two colour
 * Make sure to pop each node into the graph that isn't coloured after each attempt to 2 colour
 * to cover for a disconnected graph
 * 
 * Time complexity should be O(V^2) (if all vertices are connected to each other each vertex will need to check all other vertex)
 * Also stupid fast solution:
 *      If the max and min eigenvalues of the adjacency matrix are the same when absolute valued then the graph is bipartite
 *          I havne't learned enough math to prove this
*/

class IsBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] nodes = new int[graph.length];
        
        Deque<Integer> visiting = new ArrayDeque<Integer>();
        
        int curr;
        int col;
        int otherCol;
        int adj;
        
        for (int j = 0; j < nodes.length; j++) {
            if (nodes[j] == 0) {
                visiting.add(j);
                nodes[j] = 1;
                
                while (visiting.size() > 0) {
                    curr = visiting.poll();
                    col = nodes[curr];
                    otherCol = col == 1 ? 2 : 1;

                    for (int i = 0; i < graph[curr].length; i++) {
                        adj = nodes[graph[curr][i]];
                        if (adj == 0) {
                            nodes[graph[curr][i]] = otherCol;
                            visiting.add(graph[curr][i]);
                        }
                        else if (adj == col) {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}