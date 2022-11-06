/*
 * Orderly Queue
 *
 * Top 100% (2ms) 
 * 
 * If k == 1, shuffle the letters one by one as there are only n - 1 permutations of the string.
 * If k > 1, it is possible to get any permutation of the string, which means sorting it will give
 * you the lexographically smallest string.
 * 
 * 
 * Time Complexity: O(nlogn) 
 */

class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String ans = s;
            for (int i = 0; i < s.length(); i++) {
                s = s.substring(1, s.length()) + s.substring(0, 1);
                if (ans.compareTo(s) > 0) {
                    ans = s;
                }
            }
            return ans;
        }
        else {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }
    }
}

/*
baaca
aacab
aaabc
*/