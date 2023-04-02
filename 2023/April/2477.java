/*
 * Minimum Fuel Cost to Report to the Capital
 * 
 * Top 85% (54ms)
 * 
 * 1) Build the graph
 * 2) DFS from the capital (0) outwards, and then recusively build up the answer from the outward nodes inward
 *      2.1) We need to know how many people + cars are coming in from the outward nodes
 *      2.2) Once we have multiple people and nodes converging at a single node, we can do some basic math
 *          2.2.1) We want to minimize cars travelling, as that minimizes fuel
 *          2.2.2) Multiple cars with vacant seats means we can greedily pack cars full
 *          2.2.3) Number of cars leaving a node = number of people / seats
 *          2.2.4) Leaving cars behind has no downside; its not possible to find more people than cars available
 *      2.3) Add the number of cars departing from a node to the global answer
 * 
 * One other catch, the question involves a tree; no cycles (otherwise this would become more annoying)
 * 
 * Time Complexity: O(V + E) because dfs
 */

class Solution {
    long ans = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();

        for (int i = 0; i < roads.length + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < roads.length; i++) {
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }
        dfs(0, 0, graph, seats);

        return ans;
    }

    private int dfs(int node, int prevNode, List<List<Integer>> graph, int seats) {
        int people = 1;
        // fun fact: its faster to store the neighbours reference and do neighbours -> node
        // than reference graph -> neighbours -> node, every time (improved my times by like 20 ms)
        List<Integer> neighbours = graph.get(node);
        for (int i = 0; i < neighbours.size(); i++) {
            if (neighbours.get(i) != prevNode) {
                people += dfs(neighbours.get(i), node, graph, seats);
            }
        }    
        if (node != 0) {
            ans += Math.ceil((float)people / seats);
        }

        return people;
    }
}