/*
 * Largest Rectangle in Histogram
 *
 * Top 89% (30ms) 
 * 
 * The trick is to visualize each bar extending continuously forward until a shorter
 * bar is encountered. 
 * 
 * Time Complexity: O(n) 
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Pair<Integer, Integer>> stack = new LinkedList<>();

        stack.push(new Pair<Integer, Integer>(0, heights[0]));

        for (int i = 1; i < heights.length; i++) {
            // the next bar to be added will have a rectangle area at minimum equal to the number of 
            // bars that came before it that were taller
            int furthestBack = i;
            while (stack.size() > 0 && heights[i] < stack.peek().getValue()) {
                Pair<Integer, Integer> poppedBar = stack.pop();
                int newArea = poppedBar.getValue() * (i - poppedBar.getKey());
                maxArea = Math.max(maxArea, newArea);
                furthestBack = Math.min(furthestBack, poppedBar.getKey());
            }
            stack.push (new Pair<Integer, Integer>(furthestBack, heights[i]));
        }
        // whatever is left in the stack consists of bars that extended towards the end
        // of the histogram without encountering a shorter bar (or created via the exception above)
        while (stack.size() > 0) {
            Pair<Integer, Integer> poppedBar = stack.pop();
            int newArea = poppedBar.getValue() * (heights.length - poppedBar.getKey());
            maxArea = Math.max(maxArea, newArea);
        }
        return maxArea;
    }
}