/*
 * Remove All Adjacent Duplicates In String
 *
 * Top 73% (48ms) 
 * 
 * We have to build the string
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public String removeDuplicates(String s) {
        boolean didRemove = true;
        Deque<Character> stack = new LinkedList<Character>();

        for (int i = 0; i < s.length(); i++) {
            boolean removed = false;
            while (stack.size() > 0 && stack.peek() == s.charAt(i)) {
                stack.pop();
                removed = true;
            }
            if (removed == false) {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}