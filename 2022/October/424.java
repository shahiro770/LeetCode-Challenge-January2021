/**
 * Longest Repeating Character Replacement
 * 
 * Top 96% (5ms)
 * 
 * The trick is to realize that you don't need to increment the highest count of the highest frequency
 * letter you've encountered. Since you can only beat the longest string if you find something higher,
 * you only need to increment then.
 * 
 * Time complexity: O(n)
 */

class Solution {
    public int characterReplacement(String s, int k) {
        char[] c = s.toCharArray();
        int[] vals = new int[26];
        int left = 0;
        int right = 0;
        int longest = 0;
        int highest = 0;
        while (right < c.length) {
            int val = c[right] - 'A';
            vals[val]++;
            if (vals[val] > highest) {
                highest = vals[val];
            }
            if ((right - left + 1) - highest > k) {
                while (right - left + 1 - highest > k) {
                    val = c[left] - 'A';
                    vals[val]--;
                    left++;
                }
            }
            longest = Math.max(longest, right - left + 1);
            right++;
        }

        return longest;
    }
}

/*
DABACDED k = 2
D = D
DA = DD
DAB = DDD
DABA = AAAA
DABAC = ABAC = AAAA    // total unique character = 4, total characters = 5, vals = [2,1,1,1]
ABACD = ACD = AAA      // total unique character = 4, total characters = 5, vals = [2,1,1,1]
ACDE = CDE = CCC       // total unique character = 4, total characters = 4, vals = [1,0,1,1,1]
CDED = CDED = DDDD     // total unique character = 3, total characters = 4, vals = [0,0,1,2,1]
String can be most frequent character length + k characters long
*/