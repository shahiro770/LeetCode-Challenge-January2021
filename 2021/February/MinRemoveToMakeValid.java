/**
 * Feb 2021 Day 19
 * Top 61% I hate strings
 * 
 * All you need to do is identify how many extra/incomplete ( or ) you have.
 *      Use a stack like any balanced parantheses problem
 * From there just remove the parantheses at the indices that match the ones of the ( you know need to go
 *      Careful here, you can't just remove ( and ) to match the numbers, the string still needs to be corect
 * 
 * Time complexity is O(n) (loop through the string twice effectively)
 * 
*/

class Solution {
    public String minRemoveToMakeValid(String S) {
        char[] s = S.toCharArray();
        Deque<Character> stack = new ArrayDeque<Character>();
        Deque<Integer> indexStack = new ArrayDeque<Integer>();
        
        for (int i = 0; i < S.length(); i++) {
            Character top = stack.peekFirst();
            if (top != null && s[i] == ')' && stack.peekFirst() == '(') {
                stack.removeFirst();
                indexStack.removeFirst();
            }
            else if (s[i] == '(' || s[i] == ')') {   
                stack.addFirst(s[i]);
                indexStack.addFirst(i);
            }
        }
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (indexStack.size() > 0) {
            if (index == indexStack.peekLast()) {
                indexStack.removeLast();
            }
            else {
                sb.append(s[index]);
            }
            index++;
        }
        while (index != S.length()) {
            sb.append(s[index]);
            index++;
        }
        
        return sb.toString(); 
    }
}
