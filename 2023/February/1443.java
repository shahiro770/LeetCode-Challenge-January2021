/*
 * Minimum Time to Collect All Apples in a Tree
 * 
 * Top 96% (25ms)
 * 
 * As you dfs, only increase the path if you find an apple along the way, otherwise its a waste of going there.
 * 
 * Time Complexity: O(E + V)
 * */

class Solution {
    ArrayList<Integer>[] graph;
    List<Boolean> hasApple;
    boolean[] visited;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        graph = new ArrayList[n];
        this.hasApple = hasApple;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        visited[0] = true;
        return Math.max(DFS(0, 0) - 1, 0);  // get around the singular +1 from retunring to the root that throws the answer off, 0 in case there are no apples
    }

    public int DFS(int node, int path) {
        List<Integer> adjs = graph[node];
        int oldPath = path;

        for (int i = 0; i < adjs.size(); i++) {
            if (visited[adjs.get(i)] == false) {
                visited[adjs.get(i)] = true;
                path = DFS(adjs.get(i), path + 1);
            }
        }

        if (hasApple.get(node) == true || path != oldPath) {
            return path + 1;
        }
        else {
            return path - 1;
        }
    }
}

/*
                        0
                1                  (2)
        3           4           5       (6)
                (7)

    0 -> 1      1
    1 -> 3      2
    3 -> 1      1
    1 -> 4      2
    4 -> 7      3       APPLE CONFIRMED  (for now return path up)
    7 -> 4      4
    4 -> 1      5
    1 -> 0      6
    0 -> 2      7       APPLE CONFIRMED
    2 -> 5      8
    5 -> 2      7
    2 -> 6      8       APPLE CONFIRMED
    6 -> 2      9
    2 -> 0      10

*/