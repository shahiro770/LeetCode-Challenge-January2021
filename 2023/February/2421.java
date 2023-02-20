/**
 * Number of Good Paths
 *
 * Top 98% (31ms)
 * 
 * Hard problem to conceptualize. Read https://leetcode.com/problems/number-of-good-paths/solutions/2620584/detailed-solution-disjoint-set-union-c/?orderBy=most_votes
 * cause the actual leetcode solution hurts my brain. If this shows up on an interview rest in peace.
 * 
 * The union find solutions with treemaps seem to all run slower than the disjoint set union algorithm using a sort as shown here.
 * 
 * Time Complexity: O(nlgn)
 */

class Solution {
    int ans = 0;

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        /*
            Sort based on the largest valued node involved in each edge
        */
        Arrays.sort(edges, (a, b) -> {
            return Math.max(vals[a[0]], vals[a[1]]) - Math.max(vals[b[0]], vals[b[1]]);
        });
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1], vals);
        }
        
        return ans + n; // all nodes are good paths to themselves
    }

    private class UnionFind {
        int[] parents;
        int[] counts;

        private UnionFind (int size) {
            parents = new int[size];
            counts = new int[size];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
        }

        public int find (int i) {
            if (parents[i] != i) {
                parents[i] =  find(parents[i]);
            }

            return parents[i];
        }

        // Make y the parent of x
        private void parent(int x, int y) {
            parents[x] = y;
        }
        
        // Union subtrees, unioning the smallest trees first
        private void union(int x, int y, int[] vals) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (vals[rootX] == vals[rootY]) {
                    ans += (counts[rootX] + 1) * (counts[rootY] + 1);
                    counts[rootX] += counts[rootY] + 1;
                    parent(rootY, rootX);
                }
                else if (vals[rootX] > vals[rootY]) {
                    parent(rootY, rootX);
                }
                else {
                    parent(rootX, rootY);
                }
            }
        }
    }
}