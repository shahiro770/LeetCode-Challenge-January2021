/**
 * Restore IP Addresses
 *
 * Top 99% (1ms)
 * 
 * Backtracking is fun. The simplest observation is that you have 2 actions:
 *  1) Take the current digit
 *  2) Insert a dot
 * 
 * Each of these has a billion conditions on top of them though, which is why this has big medium energy
 *  1) You can't take any more digits after 3 contiguous digits with no dots
 *  2) You can't place dots back to back, and there's a limit of 3 dots
 *  3) No leading 0s unless the 0 is alone (*.0.*)
 *  4) A ip address chunk value must be between 0 and 255 (inclusive)
 * 
 *  With all these rules, you need to carefully add constraints to the three cases to prevent your decision tree
 *  from following dead paths.
 *
 * Time Complexity: O(3^n) I think
 */

class Solution {
    ArrayList<String> sol;
    char[] cs;
    StringBuilder sb;

    public List<String> restoreIpAddresses(String s) {
        sol = new ArrayList<String>();
        cs = s.toCharArray();
        sb = new StringBuilder();

        forwardTrack(0, 0, 0, 0, false);

        return sol;
    }
    
    /**
     * pos: position in the string
     * lastDot: positional difference between pos and the last time a dot was placed
     * numDots: number of total dots
     * tripleVal: the current value of the ip address chunk
     * leadingZero: flag for if the current chunk starts with a zero
     */
    public void forwardTrack(int pos, int lastDot, int numDots, int tripleVal, boolean leadingZero) {
        // valid ip addresses will use all digits in the string, have three dots, and all triples with value between 0 and 255
        if (pos == cs.length) {
            // we check the triple value whenever we put another dot, or at the very end of the string
            if (numDots == 3 && tripleVal <= 255) {
                sol.add(sb.toString());
            }
        }
        else {
            // insert a dot if possible
            if (numDots < 3 && lastDot > 0 && tripleVal <= 255) {
                sb.append('.');
                forwardTrack(pos, 0, numDots + 1, 0, false);
                sb.deleteCharAt(sb.length() - 1);
            }
            // insert a digit if possible
            if (numDots <= 3 && lastDot < 3) {
                // case where we are adding a leading zero; we can't follow this up with anything other than a '.'
                if (lastDot == 0 && cs[pos] == '0') {
                    sb.append(cs[pos]);
                    forwardTrack(pos + 1, lastDot + 1, numDots, 0, true);
                    sb.deleteCharAt(sb.length() - 1);
                }
                // only try to add other digits if we don't have a leading zero
                else if (leadingZero == false) {
                    sb.append(cs[pos]);
                    forwardTrack(pos + 1, lastDot + 1, numDots, tripleVal * 10 + (cs[pos] - '0'), leadingZero);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}