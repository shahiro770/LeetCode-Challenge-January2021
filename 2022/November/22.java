/*
 * Generate Parentheses
 *
 * Top 98% (1ms) 
 * 
 * It looks like you'd need a stack to validate each branch as you try left and right brackets.
 * However, the big brain solution is realizing you can branch "smartly" by first using 
 * left brackets, and then using right brackets if you have more left brackets than right brackets.
 * 
 * Time Complexity: O(n^2)
 */

class Solution {
    Set<String> solSet = new HashSet<String>();

    public List<String> generateParenthesis(int n) {
        int left = n;
        int right = n;
        StringBuilder sb = new StringBuilder();

        solve(left, right, sb);
        return new ArrayList<String>(solSet);
    }

    private void solve(int left, int right, StringBuilder sb) {
        if (left == 0 && right == 0) {
            solSet.add(sb.toString());
        }
        else {
            if (left > 0) {
                sb.append('(');
                solve(left - 1, right, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (right > left) {
                sb.append(')');
                solve(left, right - 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    // private boolean isValid(StringBuilder sb) {
    //     Deque<Character> stack = new LinkedList<Character>();

    //     for (int i = 0; i < sb.length(); i++) {
    //         if (sb.charAt(i) == '(') {
    //             stack.push(sb.charAt(i));
    //         }
    //         else if (sb.charAt(i) == ')' && stack.size() > 0 && stack.peek() == '(') {
    //             stack.pop();
    //         }
    //         else {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}