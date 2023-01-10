/*
 * Sum of Distances in Tree
 * 
 * Top 77% (68ms)
 * 
 * Really tricky problem that is a mix of DP and DFS.
 * 
 * Naively, calclulating the distance from every node will be O(n^2), but there's a completely unintuitive hack that operates
 * on less information.
 * 
 * Suppose we traverse the tree once, counting the number of children each node has, including the node itself to make
 * less magic numbers (i.e. leaf nodes will = 1, root node will = the number of nodes in the tree), as well
 * as the sumDist of the root node of the tree. Then we can observe two things:
 *  1) Going down to a child makes every node above it and on another branch from the parent node +1 distance away from it
 *  2) Going down to a child makes every node below it (i.e. its children) -1 distance away from it
 * 
 * Using these two facts, we can get the distances in a follow up preorder traversal. In short, from parent node X,
 * node Y's sumDist can be broken down as follows:
 *  1) Y's sumDist will decrease by its number of children (also include Y itself as that was counted in sumDist of its parent)
 *      This value will be stored in our childCount(Y) from before, easy to get
 *  2) Y's sumDist will increase by the number of children of its parent (also include X itself)
 *      We can get this value via childCount(X) - childCount(Y)
 * Our final formula is dp[Y] = dp[X] + childCount(X) - childCount(Y) * 2
 * 
 * The algorithm will therefore get all the distances in O(n) time.     
 * 
 * Time Complexity: O(n)
 */

class Solution {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int[] dp = new int[n];
        int[] childCount = new int[n];

        if (edges.length == 0) {
            return new int[1];
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }

        dfs(0, -1, 0, dp, childCount);
        preOrder(0, -1, dp, childCount);

        return dp;
    }

    public void dfs (int n, int parent, int level, int[] dp, int[] childCount) {
        List<Integer> adj = graph.get(n);

        dp[n] = level;

        for (int i = 0; i < adj.size(); i++) {
            if (adj.get(i) != parent) {
                dfs(adj.get(i), n, level + 1, dp, childCount);
                dp[n] += dp[adj.get(i)];
                childCount[n] += childCount[adj.get(i)] ;
            }
        }
        childCount[n] += 1;
    }

    public void preOrder(int n, int parent, int[] dp, int[] childCount) {
        List<Integer> adj = graph.get(n);
        for (int i = 0; i < adj.size(); i++) {
            if (adj.get(i) != parent) {
                dp[adj.get(i)] = dp[n] + dp.length - (childCount[adj.get(i)]) * 2;
                preOrder(adj.get(i), n, dp, childCount);
            }
        }
        
    }
}