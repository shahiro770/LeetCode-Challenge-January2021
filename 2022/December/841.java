/*
 * Keys and Rooms
 * 
 * Top 94% (1ms)
 *
 * DFS or BFS. 
 * 
 * Time Complexity: O(V + E)
 */

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int roomsVisited = 0;
        int totalRooms = rooms.size();

        Deque<Integer> stack = new ArrayDeque<Integer>();

        stack.push(0);
        boolean[] visited = new boolean[totalRooms];
        visited[0] = true;
 
        while (stack.size() > 0) {
            int room = stack.pop();
            roomsVisited++;
            List<Integer> keys = rooms.get(room);
            for (int i = 0; i < keys.size(); i++) {
                if (visited[keys.get(i)] == false) {
                    visited[keys.get(i)] = true;
                    stack.push(keys.get(i));
                }
            }
        }

        return totalRooms == roomsVisited;
    }
}