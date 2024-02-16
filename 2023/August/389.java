/**
 * Find the Difference
 * 
 * Top 66% (2ms) (train wifi maybe)
 * 
 * Frequency probably going down for a while since new job has a lot more to learn. Will pick up the pace again when I'm comfortable.
 * 
 * Time Complexity: O(n)
 * */


class Solution {
    public char findTheDifference(String s, String t) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            sum -= t.charAt(i);
        }

        return (char)(sum * -1);
    }
}