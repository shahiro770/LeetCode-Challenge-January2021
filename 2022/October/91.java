/**
 * Decode Ways
 * 
 * October 2022
 * Top 74% (2ms)  
 * 
 * 1d DP that is sorta not really dp but idk what to call it.
 *   
 * Looking at a smaller problem, if we only had say 3 characters 
 * "1122"
 * 
 * dp[3] = 1 (only one way to decode it)  
 * dp[2] = 1 + dp[3] = 2 since its a 2, 0-6 before it is a valid alphabet letter (1 to 26)
 *      We could view it as 2,2 or 22
 * dp[1] = 1 + dp[2] = 3 since its a 1, 0-9 before it is a valid alphabet letter (1 to 26)
 *      (1,2,2) or (12, 2) or (1, 22)
 * dp[0] = 1 + dp[1] = 5
 *      (1,1,2,2) or (11, 2, 2) or (1, 12, 2) or (1,1, 22) or (11,22)
 * 
 * How would we compute 5 for dp[0]?
 *      If we take the 0th character as an individual 1, we can think of it as adding a 1 to the front of decode("122")
 *          decode("122") = dp[0 + 1] = dp[1] = 3
 *          Notice how the newest character alone wouldn't increase the number of ways to decode the string
 *      If we take the last one and pair it with the 1 before it, we have instead "11" + decode("22")
 *          decode("22") = dp [0 + 2] = dp[2] = 2
 *      Adding both of the only two possible logic branches together gets us a total of 5
 * 
 * Similar logic applies to dp[1], but its easier to visualize with that fourth character.
 * 
 * Time complexity: O(n) 
 */

class Solution {
    public int numDecodings(String s) {

        int[] dp = new int[s.length() + 1]; 
        char[] sc = s.toCharArray();
        dp[dp.length - 1] = 1; 
        
        for (int i = sc.length - 1; i >= 0; i--) {
            // assume initially there is only one way to decode the string
            dp[i] = 1;

            // if it's a 0, it can't be the start of the string, aka its 0 ways
            if (sc[i] == '0') {
                dp[i] = 0;
            }
            else if (i + 1 < sc.length) {
                dp[i] = dp[i + 1];
            }
            if (i + 1 < sc.length && (sc[i] == '1' || (sc[i] == '2' && sc[i + 1] <= '6'))) {
                dp[i] += dp[i + 2];
            }
        }
        
        return dp[0];
    }
}