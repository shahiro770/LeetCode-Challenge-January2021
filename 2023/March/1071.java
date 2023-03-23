/*
 * Greatest Common Divisor of Strings
 *
 * Top 87% (1ms) 
 * 
 * Hardest leetcode easy of all time. Just see this, I am tilted
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/solutions/3124940/c-one-line-beats-100-runtime-explanation/?orderBy=most_votes
 * 
 * Time Complexity: O(n^2), where n is the total number of characters in all strings
 */


class Solution {
    public int gcd(int a, int b) {
        return (b == 0)? a : gcd(b, a % b);
    }
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcd = gcd(str1.length(), str2.length());
        return str2.substring(0, gcd);
    }
}
