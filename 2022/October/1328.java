/*
 * Break a Palindrome
 * 
 * October 2022
 * Top 100% (0ms)
 *
 * Three cases:
 * 1) the string is length 1; we can't break a palindrome of length 1 and return ""
 * 2) the string is all "a"; replace the last character with a b as its the next lexographically highest string
 * 3) not 1) or 2), look at first floor(n/2) characters, swap the first one that isn't "a"
 *
 * Time complexity: O(n) 
*/

class Solution {
    public String breakPalindrome(String palindrome) {
        char[] c = palindrome.toCharArray();
        int left = 0;
        int lowest = -1;

        if (c.length == 1) {
            return "";
        }

        while (left < c.length / 2) {
            if (c[left] != 'a') {
                lowest = left;
                break;
            }
            left++;
        }
        if (lowest == -1) {
            c[c.length - 1] = 'b';
            return new String(c);
        }
        c[lowest] = 'a';
        return new String(c);
    }
}