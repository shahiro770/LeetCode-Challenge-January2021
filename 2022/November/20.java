/*
 * Valid Parentheses
 *
 * Top 79% (3ms) 
 * 
 * Stack
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<Character>();

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else {
                if (stack.size() == 0) { // closing bracket with nothing to close with means invalid
                     return false;
                }
                else if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                }
                else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                }
                else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                }
                else {  // bracket mismatch is invalid
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }
}