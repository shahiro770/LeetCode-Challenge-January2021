/**
 * Feb 2021 Day 26
 * Top 52% but I mean 2ms runtime is good enough
 * 
 * Wheneve an element is pushed check if it can be popped
 *  If it can be popped, keep popping while the stack top matches the current action in the popped array
 * By the end of the algorithm, if the popped array hasn't been fully used, return false
 *      
 * Time complexity is O(n)
 *      Each element in the stack experiences two operations at most
 */

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        
        int pushedIndex = 0;
        int poppedIndex = 0;
        
        while (pushedIndex != pushed.length) {
            stack.push(pushed[pushedIndex]);
            pushedIndex++;
            
            while (stack.peek() != null && stack.peek() == popped[poppedIndex]) {
                stack.poll();
                poppedIndex++;
                if (poppedIndex == popped.length) {
                    break;
                }
            }
            if (poppedIndex == popped.length && pushedIndex != pushed.length) {
                return false;
            }
        }
        
        return poppedIndex == popped.length;
        
    }
}