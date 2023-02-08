/**
 * Lexicographically Smallest Equivalent String
 *
 * Top 100% (1ms)
 * 
 * Equate all characters with a union find, prioritizing the lexigraphically smallest as the parent node every time.
 *
 * Time Complexity: O(n)
 */

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind uf = new UnionFind(26);

        for (int i = 0; i < s1.length(); i++) {
            uf.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < baseStr.length(); i++) {
            sb.append((char)(uf.find(baseStr.charAt(i) - 'a') + 'a'));
        }

        return sb.toString();
    }

    private class UnionFind {
        int[] parents;

        private UnionFind(int n) {
            parents = new int[n];

            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        // finds the parent of x
        private int find(int x) {
            while(parents[x] != x) {
                x = find(parents[x]);
            }

            return x;
        }

        // sets the parent of x to y
        private void parent(int x, int y) {
            parents[x] = y;
        }

        // make the parent of set x the parent of set y
        private void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx < rooty) {
                parent(rooty, rootx);
            }
            else {
                parent(rootx, rooty);
            }
        }
    }
}