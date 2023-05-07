/*
 * Excel Sheet Column Title
 *
 * Top 100% (0ms)
 * 
 * Time Complexity: O(n)
 */

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();

        while (n > 0) {
            n--;
            res.append((char)('A' + n % 26));
            n /= 26;
        }
        
        res.reverse();
        return res.toString();
    }
}