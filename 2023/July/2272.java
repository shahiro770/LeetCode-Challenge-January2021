/*
 * Substring With Largest Variance
 * 
 * Top 30% (266ms) Another leetcode hard. Another me looking up the solution after getting bodied by TLE
 * 
 * The whole idea of substrings is more or less conceptual. You don't need to go out of your way to create them.
 * Rather the solution lies in scanning the string from left to right like a pseudo sliding window. You try every single
 * pair of characters (26 * 26 combos), treating one character as the "min frequency" and another as the "max frequency", 
 * trying to see what combination gets you the largest frequency diff. 
 * 
 * What simplifies this process greatly is doing a frequency count at the start for all characters. From there you start at 
 * the beginning of the string and "decrease" the count whenever you see a character you're currently examinig (effectively moving
 * the start of the substring). 
 * 
 * Time Complexity: O(26 * 26 * n)
 */

class Solution {
    public int largestVariance(String s) {
        int[] freq = new int[26];
        int n = s.length();
        for (int i = 0; i  < n; i++) {
            freq[(int)(s.charAt(i) - 'a')]++;
        }

        int maxVariance = 0;
        for (int a = 0; a < 26; a++) {
            for (int b = 0; b < 26; b++) {
                int remainingA = freq[a];
                int remainingB = freq[b];

                if (a != b & remainingA > 0 && remainingB > 0) {
                    int currAFreq = 0;
                    int currBFreq = 0;

                    for (int i = 0; i < n; i++) {
                        int c = (int)(s.charAt(i) - 'a');

                        if (c == b) {
                            currBFreq++;
                            remainingB--;
                        }
                        if (c == a) {
                            currAFreq++;
                            remainingA--;
                        }

                        if (currAFreq > 0) {
                            maxVariance = Math.max(maxVariance, currBFreq - currAFreq);
                        }
                        /*
                            If we've counted fewer B's than A's but know there's more A's
                            available in the current string, we reset, (effectively moving the start of the substring upwards). 
                            Since A is the min freq char and B is the max freq, we need B to be greater than A 
                            (and the opposite pairing will eventually be handled anyways)
                        */
                        if (currBFreq < currAFreq && remainingA >= 1) {
                            currAFreq = 0;
                            currBFreq = 0;
                        }
                    }
                }
            }
        }

        return maxVariance;
    }
}