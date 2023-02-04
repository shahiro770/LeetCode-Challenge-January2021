/**
 * Longest Path With Different Adjacent Characters
 * 
 * Top 70% (123ms)
 * 
 * Time Complexity: O(N * V + E) 
 */ 

class Solution {
    String s;
    ArrayList<Integer>[] graph;
    int sol = 1;

    public int longestPath(int[] parent, String s) {
        graph = new ArrayList[parent.length];
        this.s = s;

        for (int i = 0; i < parent.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i < parent.length; i++) {
            graph[parent[i]].add(i);
        }
        dfs(0);

        return sol;
    }

    public int dfs(int node) {
        ArrayList<Integer> children = graph[node];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> { return b - a; });

        for (int i = 0; i < children.size(); i++) {
            int branchPathLength = dfs(children.get(i));
            if (s.charAt(children.get(i)) != s.charAt(node)) {
                pq.offer(branchPathLength);
            }
        }

        int big1 = pq.isEmpty() ? 0 : pq.poll();
        int big2 = pq.isEmpty() ? 0 : pq.poll();
        sol = Math.max(sol, big1 + big2 + 1);
        return big1 + 1;
    }
}

/*
Two cases:
1) The current node can form a "U" between its left and right longest paths (so the path goes through)
2) We can't use the current node cause its adjacents are both the same character, so the longest path can't travel through it

    a
        b
            a           LONGEST 3
                a
                    b
                c       d
            e               f       LONGEST 5

return U if U > biggest1 + 1  and U > biggest2 + 1
    else return max(biggest1 + 1, biggest2 + 1)
        
*/