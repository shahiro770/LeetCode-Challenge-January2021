/*
 * Possible Bipartition
 * 
 * Top 81% (24ms)
 * 
 * Build the adjacency list, and then do a 2-colouring with BFS to determine if you can make a bipartition.
 * 
 * Time Complexity: O(V + E)
 * /

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        int[] colours = new int[n + 1];

        for (int[] pair : dislikes) {
            int a = pair[0];
            int b = pair[1];
            adjList.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adjList.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }

        Deque<Integer> queue = new ArrayDeque<Integer>();
        int visited = 0;

        while(queue.size() > 0 || visited != n) {
            if (queue.size() == 0) {
                for (int i = 1; i < colours.length; i++) {
                    if (colours[i] == 0) {
                        colours[i] = 1;
                        queue.offer(i);
                        visited++;
                        break;
                    }
                }
            }
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                int curr = queue.poll();
                int adjColour = colours[curr] == 1 ? 2 : 1;
                List<Integer> node = adjList.get(curr);
                if (node != null) {
                    for (int j = 0; j < node.size(); j++) {
                        if (colours[node.get(j)] == colours[curr]) {
                            return false;
                        }
                        if (colours[node.get(j)] == 0) {
                            visited++;
                            colours[node.get(j)] = adjColour;
                            queue.offer(node.get(j));
                        }
                    }
                }
            }
        }

        return true;
    }
}