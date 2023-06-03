/*
 * Detonate the Maximum Bombs
 * 
 * Top 37% (159 ms) (its slow cause im too lazy to not flood the call stack)
 * 
 * The tricky part here is figuring out if a bomb can detonate another bomb.
 * To do this, use the distance between two points formula for bombs b1 and b2
 * (with b1 detonating)
 *      1) ((x2 - x1)^2 + (y2 - y1)^2)^(1/2) = d
 *      2) (x2 - x1)^2 + (y2 - y1)^2 = d^2
 *      Now in our case, as long as the distance is less than that explosion radius,
 *      we can consider b2 in the radius of b1. So our formula becomes
 *      3) (x2 - x1)^2 + (y2 - y1)^2 <= r1^2
 * 
 * With this, we can construct a graph (b1 and b2 share an edge if b2 is in the radius
 * of b1). From here its your choice of dfs or bfs to find the largest connected component.
 * 
 * Time Complexity: O(n + n^2) if every bomb can reach every other bomb
 */

class Solution {
    public int maximumDetonation(int[][] bombs) {
        int sol = 0;
        ArrayList<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < bombs.length; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < bombs.length; i++) {
            // need to use long cause the max radius (10 ^6 will overflow when squared)
            long x = bombs[i][0];
            long y = bombs[i][1];
            long r = (long)bombs[i][2] * (long)bombs[i][2]; 
            for (int j = 0; j < bombs.length; j++) {
                if (((x - bombs[j][0]) * (x - bombs[j][0])) + ((y - bombs[j][1]) * (y - bombs[j][1])) <= r) {
                    graph.get(i).add(j);

                }
            }
        }

        for (int i = 0; i < bombs.length; i++) {
            boolean[] detonated = new boolean[bombs.length];
            sol = Math.max(dfs(i, graph, detonated), sol);
        }

        return sol;
    }

    public int dfs (int i, ArrayList<List<Integer>> graph, boolean[] detonated) {
        int count = 0;
        if (detonated[i] == false) {
            detonated[i] = true;
            count++;
            for (int j = 0; j < graph.get(i).size(); j++) {
                count += dfs(graph.get(i).get(j), graph, detonated);
            }
        }

        return count;
    }
}