/**
 * Maximum Performance of a Team
 * 
 * September 2022
 * Top 55% (5ms)
 * 
 * Sort the list by efficiency in decreasing order and then start adding engineers to a priority queue.
 * The engineer with the lowest speed gets removed once the team's size is maxed out since they'll
 * be the least efficient as the efficiency drops.
 * Keep track of the highest performance you see as you keep up this adding process (covers the
 * cases where one engineer was the most efficient and etc.)
 * This solution is greedy but works since we try every maximum performance engineering combination
 * with a subset of the engineers.
 * 
 * Time complexity: O(nlogn + nlogk) due to sort and heap property of priority queue with k elements
 */

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        double mod = Math.pow(10, 9) + 7;
        int[][] se = new int[speed.length][2];
        long performance = 0;
        long sumSpeed = 0;
        
        for (int i = 0; i < speed.length; i++) {
            se[i][0] = speed[i];
            se[i][1] = efficiency[i];
        }
        
        Arrays.sort(se, (a, b) -> b[1] - a[1]);
        PriorityQueue<int[]> performanceQueue = new PriorityQueue<int[]>(new EngiComp());
        
        for (int i = 0 ; i < se.length; i++) {
            performanceQueue.add(se[i]);
            sumSpeed += se[i][0];
            // System.out.println(se[i][0] + " " + se[i][1]);
            if (performanceQueue.size() > k) {
                int[] worst = performanceQueue.poll();
                sumSpeed -= worst[0];
            }
            
            // After removing the bottom performer, see if the max performance
            // with the new engi is better.
            // se[i][1] is the efficiency of the newest addition, who due to the
            // sorting earlier, is guaranteed to have the lowest efficiency.
            // If the new engi is the one who gets removed, performance will stay
            // the same.
            performance = Math.max(performance, sumSpeed * se[i][1]);
        }
        
        return (int) (performance % (long)(1e9 + 7));
    }
    
    class EngiComp implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
           return a[0] - b[0];
        }
    }
}
/*
6
[2,10,3,1,5,8]
[5,4,3,9,7,2]
2
6
[2,10,3,1,5,8]
[5,4,3,9,7,2]
3
6
[2,10,3,1,5,8]
[5,4,3,9,7,2]
4
4
[50,9,5,9]
[1,2,6,9]
2
4
[2,5,5,5]
[3,3,3,5]
4
*/