/**
 * Cheapest Flights Within K Stops
 *
 * Top 53% (8ms)
 * 
 * Dp problem that can be solved in O(n) but I had a hard time conceptualizing it.
 * DP to keep track of the cheapest way to reach a given node for i <= k jumps
 *
 * Time Complexity: O(nlgn) due to priorityQueue/maxheap
 */

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // int[][] graph = new int[n][n];
        HashMap<Integer, ArrayList<int[]>> graph = new HashMap<Integer, ArrayList<int[]>>();
        k += 1;                              //  k = max number of stops, treat k + 1 as max number of jumps
        int[][] dp = new int[n][k + 1];      //  dp[n][k] = cheapest cost to get n with k jumps
    
        // build the graph
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<int[]>());
            for (int j = 0; j < k + 1; j++) {
                dp[i][j] = -1;
            }
        }
        for (int[] flight : flights) {
            ArrayList<int[]> adjs = graph.get(flight[0]);
            adjs.add(flight);
        }

        /*
            int[0] = nodeIndex
            int[1] = totalWeight
            int[2] = k
        */
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
            if (a[1] == b[1]) {
                return b[2] - a[2];
            }
            return a[1] - b[1];
        });

        pq.offer(new int[]{ src, 0, 0 });
        dp[src][0] = 0;

        while (pq.size() > 0) {
            int[] node = pq.poll();
            // return solution if we find it
            if (node[0] == dst) {
                return node[1];
            }
            ArrayList<int[]> adjs = graph.get(node[0]);

            // if jumps can be made from the current node, DP out
            if (node[2] + 1 <= k ) {
                for (int i = 0; i < adjs.size(); i++) {
                    int adj = adjs.get(i)[1];
                    int pathCost = adjs.get(i)[2] + node[1];
                    // only try the node if its unvisited, or if we have a cheaper path that warrants re-trying the node
                    if (dp[adj][node[2] + 1] == -1 || pathCost < dp[adj][node[2] + 1]) {
                        int[] newNode = new int[] { adj, pathCost, node[2] + 1 };
                        dp[adj][newNode[2]] = pathCost;
                        pq.offer(newNode);
                    }
                }
            }
        }

        // no path to the destination
        return -1;
    }
}