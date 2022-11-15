/*
 * Most Stones Removed with Same Row or Column
 * 
 * Top 87% (22ms)
 * 
 * Since the restriction says you can remove a stone as long as it has either a row
 * or a column with a non-removed stone. In other words, you can remove a stone as long as 
 * there's another stone on the same x or y axis.
 * 
 * This devolves the problem into a bunch of connected components, where you can remove every stone
 * connected except for the last one.
 * 
 * You can DFS to find the graphs, or the more efficient union find algorithm which I'm doing
 * for the second time ever. Solution is borrowed as I don't understand unionfind well enough yet
 * and DFS gets you bottom 50%.
 * 
 * Time complexity: O(nlogn)
 * 
 * */

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;

        UnionFind uf = new UnionFind();
        for (int i = 0; i < n; i++) {
            int[] row = stones[i];
            uf.union(row[0] + 10001, row[1]);
        }

        return n - uf.getCount();
    }

    private class UnionFind {
        Map<Integer, Integer> parents; 
        int count;  // number of clusters

        public UnionFind() {
            parents = new HashMap<Integer, Integer>();
            count = 0;
        }

        // returns the number of clusters
        public int getCount() {
            return count;
        }

        // returns the parent of a given node, or adds it to the parents list
        // if it has no parents
        public int find (int x) {
            // if the newly found node is not recorded, it is a new cluster
            if (parents.containsKey(x) == false) {
                parents.put(x, x);
                count++;
            }

            // if the found node is not its own parent, continue upwards
            // this will ultimately compress the graph as all nodes with their
            // parent not being the root will be updated to have their root as such
            if (x != parents.get(x)) {
                parents.put(x, find(parents.get(x)));
            }

            return parents.get(x);
        }

        // unify two clusters, making x a child of Y
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            //
            if (rootX != rootY) {
                parents.put(rootX, rootY);
                count--;
            }
        }
    }
}