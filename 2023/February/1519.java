/**
 * Number of Nodes in the Sub-Tree With the Same Label
 * 
 * Top 90% (61ms)
 * 
 * Just pass the array count up to the parents to add. Its always a fixed 26 length, so time complexity is just the DFS.
 * 
 * Time Complexity: O(v + e) 
 */ 

class Solution {
    ArrayList<Integer>[] graph;
    int[] sol;
    boolean[] visited;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        graph = new ArrayList[n];
        sol = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        visited[0] = true;
        dfs(0, labels, new int[26]);

        return sol;
    }

    public int[] dfs(int node, String labels, int[] matchCount) {
        ArrayList<Integer> adjs = graph[node];

        for (int i = 0; i < adjs.size(); i++) {
            if (visited[adjs.get(i)] == false) {
                visited[adjs.get(i)] = true;
                int[] childMatch = dfs(adjs.get(i), labels, new int[26]);
                for (int j = 0; j < matchCount.length; j++) {
                    matchCount[j] += childMatch[j];
                }
            }
        }

        sol[node] = ++matchCount[labels.charAt(node) - 'a'];

        return matchCount;
    }
}