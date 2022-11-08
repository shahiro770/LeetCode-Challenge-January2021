/*
 * Evaluate Reverse Polish Notation
 *
 * Top 82% (8ms) 
 * 
 * Stacks all day every day
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<Integer>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push((b + a));
            }
            else if (tokens[i].equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push((b - a));
            }
            else if (tokens[i].equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push((b * a));
            }
            else if (tokens[i].equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push((b / a));
            }
            else {
                stack.push(Integer.parseInt(tokens[i]));             
            }
        }

        return stack.peek();
    }
}