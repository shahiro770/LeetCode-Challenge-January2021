/*
 * All Paths From Source to Target
 * 
 * Top 99% (1ms)
 * 
 * Simple DFS. Use recursion to not have to make multiple copies of the arraylist when traversing and pass
 * the same reference, only copying when putting it in the solution.
 * 
 * Time Complexity: O(V + E)
 */

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ArrayList<List<Integer>> sol = new ArrayList<>();   
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(0);

        traverse(0, sol, path, graph);

        return sol;
    }

    public void traverse(int node, ArrayList<List<Integer>> sol, ArrayList<Integer> path, int[][] graph) {
        for (int i = 0; i < graph[node].length; i++) {
            if (graph[node][i] == graph.length - 1) {
                path.add(graph[node][i]);
                sol.add(new ArrayList<Integer>(path));
                path.remove(path.size() - 1);
            }
            else {
                path.add(graph[node][i]);
                traverse(graph[node][i], sol, path, graph);
                path.remove(path.size() - 1);
            }
        }
    }
}