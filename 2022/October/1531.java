/**
 * String Compression II
 * 
 * Top 81% (51ms)
 * 
 * Stupid DP problem
 * 
 * Time Complexity: O(n^2*k)
 * */

class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        char[] c = s.toCharArray();
        int[][] dp = new int[c.length + 1][k + 1];
        /*
        First state = index in string
        Second state = the shortest compressed string after j deletions (0 <= j <= k)
        */
        if (k >= c.length) {
             return 0;
        }

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], c.length);   // we will be taking mins later
        }
        
        dp[0][0] = 0;
        for (int i = 1; i <= c.length; i++) {
            for (int j = 0; j <= k; j++) {
                /*
                Case 1: c[i] Deletion
                See what the string looks like if we delete c[i].
                dp[i][j] will be the same length as what dp[i - 1][j - 1] was in the previous index.
                Notice how, its j - 1. So if we are looking at dp[3][3] = dp[2][2], that says:
                    dp[3][3] = index 3 with 3 deletions
                    dp[2][2] = index 2 with 2 deletions
                    These are equivalent since we are making another deletion on top of the 2 deletions previously
                */
                if (j > 0) {   
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
                /*
                Case 2: Greedy Deletion
                We'll keep c[i], but see what the string would look like
                if we deleted up to k characters that aren't the same as c[i]. In other words,
                we are trying to remove anything thats stopping us from compressing c[i] and
                what came before, which might not be possible, but in theory will give us 
                the shortest string at i (which is why its greedy, its just a local optimum).
                dp[i][j] will be the shortest of all these attempted deletions, but this might 
                not change from the previous "delete c[i]" case, which by this same logic,
                will account for previous greedy deletion
                */
                int same = 0;
                int diff = 0;
                for (int m = i; m >= 1; m--) {
                    if (c[i - 1] == c[m - 1])  {
                        same++;
                    }
                    else {
                        diff++;
                        if (diff > j) {
                            break;
                        }
                    }
                    
                    // System.out.println("same "  + same + " diff: " + diff);
                    dp[i][j] = Math.min(dp[i][j], dp[m - 1][j - diff] + getChainLength(same)); 
                }
            }
        }

        return dp[c.length][k];
    }

    // get the length of the chain after compression
    private int getChainLength(int length) {
        if (length == 0) {  
            return 0;
        }
        else if (length == 1) { // "a" = "a" = 1
            return 1;
        }
        else if (length < 10) { // "aa" = "2a" = 2, "aaaaaaaaa" = "9a" = 2
            return 2;
        }
        else if (length < 100) { // a chain of 99 a's = "99a"
            return 3;
        }
        else {  // the constraint says there won't be more than 100 characters in the string, 100 a's = "100a"
            return 4; 
        }
    }
}