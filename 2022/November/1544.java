/*
 * Make The String Great
 *
 * Top 93% (3ms) 
 * 
 * 32 character difference between lower and upper case characters.
 * 
 * Time Complexity: O(n) 
 */

class Solution {
    public String makeGood(String s) {
        boolean noChange = false;
        StringBuilder sb = new StringBuilder();
        while (noChange == false) {
            noChange = true;
            for (int i = 0; i < s.length(); i++) {
                if (sb.length() > 0 && (sb.charAt(sb.length() - 1) + 32 == s.charAt(i) || sb.charAt(sb.length() - 1) - 32 == s.charAt(i))) {
                    sb.delete(sb.length() - 1, sb.length());
                }
                else {
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}