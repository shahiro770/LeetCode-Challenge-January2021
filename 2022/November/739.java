/*
 * Daily Temperatures
 *
 * Top 70% (147ms)
 * 
 * Pop off once we see a temperature that is greater.
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] sol = new int[temperatures.length];

        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < temperatures.length; i++) {
            while (stack.size() > 0  && temperatures[stack.peek()] < temperatures[i]) {
                int oldPos = stack.pop();
                sol[oldPos] = i - oldPos;
            }
            stack.push(i);
        }

        return sol;
    }
}