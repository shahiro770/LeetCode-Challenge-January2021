/*
 * Total Cost to Hire K Workers
 * 
 * Top 97% (61 ms) 
 * 
 * You need to take the min from two windows. The catch is the windows may merge/overlap, in which case
 * you only have one window to take a min from. Easiest way to do this is with two heaps.
 * 
 * Time Complexity: O(nlgn) cause heapifying n elements if k == costs.length
 */

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> pqL = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pqR = new PriorityQueue<Integer>();

        long totalCost = 0;
        int hired = 0;
        int left = 0;
        int right = costs.length - 1;
        boolean merged = false;

        // windows start merged 
        if (right - candidates < left + candidates) {
            merged = true;
            for (int i = 0; i < costs.length; i++) {
                pqL.offer(costs[i]);
            }
        }
        else {
            while (left < candidates) {
                pqL.offer(costs[left++]);
            }
            while (costs.length - right - 1 < candidates) {
                pqR.offer(costs[right--]);
                
            }
        }

        while (hired < k) {
            if (merged == false) {
                if (pqL.peek() <= pqR.peek()) {
                    totalCost += pqL.poll();
                    pqL.offer(costs[left++]);
                }
                else {
                    totalCost += pqR.poll();
                    pqR.offer(costs[right--]);
                }

                hired++;
                if (right < left) {
                    merged = true;
                }
            }
            else if (merged == true) {
                if (pqR.size() == 0 || (pqL.size() > 0 && pqL.peek() <= pqR.peek())) {
                    totalCost += pqL.poll();
                }
                else {
                    totalCost += pqR.poll();
                }

                hired++;
            }
        }

        return totalCost;
    }
}