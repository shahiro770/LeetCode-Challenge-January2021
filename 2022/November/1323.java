/*
 * Maximum 69 Number
 *
 * Top 88% (1ms) 
 * 
 * Bruh.
 * Probably a 0ms solution if you don't convert but i'm too lazy.
 * 
 * Time Complexity: O(n) 
 */

class Solution {
    public int maximum69Number (int num) {
        String s = String.valueOf(num);
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '6') {
                c[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(c));
    }
}