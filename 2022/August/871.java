/**
 * Minimum Number of Refueling Stops
 * 
 * August 2022
 * Top 72% (5ms)
 * 
 * You don't backtrack to previous fuel stations! Here's an abstract example of how I needed
 * to think about the problem.
 * Given stations A,B,C and destination D where A < B < C < D in distance from the start:
 * 
 * Suppose you stopped at station C as you had enough starting fuel. But C doesn't give you
 * enough fuel to reach D. You now change your route to say you stopped at B along the way and 
 * now have the combined fuel of B and C, which is enough to reach D.
 * 
 * In other words:
 * 1) Make note of the stations along the way within your maximum reach with your current fuel
 * 2) Greedily take the station from among these noted stations that gives you the most fuel (increasing your max reach)
 * 3) Repeat 1), 2) until you reach your destination
 * 
 * If all stations get used up and you can't reach your destination, its impossible.
 * 
 * Time Complexity: O(nlogn) because we use a heap for BFS
 */

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // Greed with our pq/heap; you want to always use the station that provides the most fuel
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> b[1] - a[1]);
        
        int maxReach = 0;
        int pos = 0;
        int stops = -1; // start at -1 just so we can add the starting position in a clean way to the heap
        
        pq.offer(new int[] {0, startFuel});
        
        while (pq.size() > 0) {
            int[] station = pq.poll();
            stops += 1;
            maxReach += station[1];
            
            if (maxReach >= target) {
                return stops;
            }
            
            for (int i = pos; i < stations.length; i++) {
                if (stations[i][0] <= maxReach) {
                    pq.offer(stations[i]);
                    pos++;
                }
            }
        }
        
        return -1;
    }
}