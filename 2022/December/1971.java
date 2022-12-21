/**
 * Find if Path Exists in Graph
 *
 * Top 82% (37ms)
 * 
 * Introductory union find problem. You can try BFS/DFS, but you will get a 100ms runtime and cry.
 * 
 * Quick rundown on the union find data structure:
 *      1) Everyone is a parent of themselves to start
 *      2) Having a common parent = part of the same set
 *      3) The act of unioning is making the parent of one set the parent of another set as well
 * Time Complexity: O(m * alpha(n)), where m is the number of edges, n is the number of nodes,
 * and alpha(n) is the inverse ackermann function. A(n,n) is the ackermann function.
 *      This function grows extremely slowly, but still isn't linear (https://en.wikipedia.org/wiki/Ackermann_function#Inverse)
 *          As referenced, alpha(n) < 5 for most practical input, A(4,4) > 2^2^2^2^16 (oh my god)
 *      The operation of union-finding is basically O(n)
 */

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            uf.union(edges[i][0], edges[i][1]);
        }

        // if  both nodes have the same parent, there is a path
        return uf.find(source) == uf.find(destination);
    }

    private class UnionFind {
        int[] parents;

        private UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        // If the current node isn't its own parent, check its parent and see if that node is its own parent
        // i.e. find the parent of the set
        private int find(int x) {
            if (parents[x] != x) {
                return find(parents[x]);
            }
            return x;
        }

        // Make y the parent of x
        private void parent(int x, int y) {
            parents[x] = y;
        }
        
        // make the parent of set y the parent of set x
        private void union(int x, int y) {
            parent(find(x), find(y));
        }
    }
}