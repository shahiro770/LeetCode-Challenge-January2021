/**
 * Find K Closest Elements
 * 
 * September 2022
 * Top 96% (10ms)  
 * 
 * Sweep from left to right, using priority queues to keep track of the tallest house at any time.
 * 
 * Time complexity: O(nlogn) 
 */

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> inactive = new PriorityQueue<int[]>((a, b) -> {
            if (a[0] == b[0]) {
                return b[2] - a[2];
            }
            return a[0] - b[0];
        });
        PriorityQueue<int[]> alive = new PriorityQueue<int[]>((a, b) -> b[2] - a[2]);
        ArrayList <List<Integer>> sol = new ArrayList<List<Integer>>();
        int endX = 0;

        for (int i = 0; i < buildings.length; i++) {
            inactive.add(buildings[i]);
            if (buildings[i][1] > endX) {
                endX = buildings[i][1];
            }
        }

        int currentHeight = 0;
        int x = 0;        

        while (alive.size() > 0 || inactive.size() > 0) {
            // Case 1: No houses are alive, take the first one seen and its top left coordinate
            if (alive.size() == 0 && inactive.size() > 0) {
                alive.offer(inactive.poll());
                x = alive.peek()[0];
                currentHeight = alive.peek()[2];
                addCoord(x, currentHeight, sol);
            }
            // Case 2: the current alive house ends before the next inactive one
            // we can remove it and look for the next shortest alive house
            else if (alive.size() > 0 && inactive.size() > 0 && alive.peek()[1] < inactive.peek()[0]) {
                x = alive.peek()[1];
                // get rid of any alive houses that ended at or before the current house
                while (alive.size() > 0 && alive.peek()[1] <= x) {
                    alive.poll();
                }
                // Case 2.1: take the tallest house and record its bottom left/top right coordinate
                if (alive.size() > 0) {
                    // In the edge case that the new active house is the same height as the previous,
                    // don't create a new coordinate
                    if (alive.peek()[2] != currentHeight) {
                        currentHeight = alive.peek()[2];
                        addCoord(x, currentHeight, sol);
                    }
                }
                // Case 2.2: if no alive houses are left, we dropped off back to 0
                else {
                    currentHeight = 0;
                    addCoord(x, currentHeight, sol);
                }
            }
            // Case 3: if an inactive house is coming up before the current house ends, add it to the alive houses
            else if (alive.size() > 0 && inactive.size() > 0 && inactive.peek()[0] <= alive.peek()[1]) {
                 alive.offer(inactive.poll());
                 // if its taller, record its peek
                 if (alive.peek()[2] > currentHeight) {
                    x = alive.peek()[0];
                    currentHeight = alive.peek()[2];
                    addCoord(x, currentHeight, sol);
                 }
            }
            // Case 4: All inactive houses have been seen, and we only have alive houses
            else if (alive.size() > 0) {
                x = alive.peek()[1];
                // get rid of any alive houses that ended at or before the current house
                while (alive.size() > 0 && alive.peek()[1] <= x) {
                    alive.poll();
                }
                // Case 4.1: take the tallest house and record its bottom left/top right coordinate
                if (alive.size() > 0) {
                    // In the edge case that the new active house is the same height as the previous,
                    // don't create a new coordinate
                    if (alive.peek()[2] != currentHeight) {
                        currentHeight = alive.peek()[2];
                        addCoord(x, currentHeight, sol);
                    }
                }
                // Case 4.2: if no alive houses are left, we dropped off back to 0
                else {
                    currentHeight = 0;
                    addCoord(x, currentHeight, sol);
                }
            }
        }    

        return sol;
    }

    private void addCoord(int x, int y, ArrayList<List<Integer>> sol) {
        ArrayList<Integer> coords = new ArrayList<Integer>();
        coords.add(x);
        coords.add(y);
        sol.add(coords);
    }
}