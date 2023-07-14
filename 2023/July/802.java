/*
 * Find Eventual Safe States
 *
 * Top 67% (6ms)
 * 
 * Solution copied from https://leetcode.com/problems/find-eventual-safe-states/solutions/119871/straightforward-java-solution-easy-to-understand/
 * because I'm learning topological sort.
 * 
 * The trick with this question is the need to detect cycles (my outgoing edge method from 207 doesn't work as nicely here).
 * To do so, follow this algorithm
 * 1) Any unvisited node is marked as null
 * 2) Upon visiting a node, mark it as UNSAFE
 * 3) Visit all of the current node's neighbours, repeating the process (i.e. DFS)
 * 4) A node is marked SAFE if none of its neighbours are UNSAFE (as that means there's a cycle)
 *  4.1) This also means the very first node to be marked as SAFE will be one with no outgoing edges
 * 
 * Time Complexity: O(V + E)
 */

class Solution {

    enum State {
        SAFE,
        UNSAFE
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes = new ArrayList<Integer>();
        State[] states = new State[graph.length];

        // this also covers nodes with no edges as we'll visit everything eventually
        for (int node = 0; node < graph.length; node++) {
            if (isSafe(graph, node, states)) {
                safeNodes.add(node);
            }
        }

        return safeNodes;
    }

    private boolean isSafe(int[][] graph, int node, State[] states) {
        if (states[node] != null) {
            return states[node] == State.SAFE;
        }

        states[node] = State.UNSAFE;

        for (int i = 0; i < graph[node].length; i++) {
            if (isSafe(graph, graph[node][i], states) == false) {
                return false;
            }
        }

        states[node] = State.SAFE;
        return true;
    }
}