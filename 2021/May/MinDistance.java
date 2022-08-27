/**
 * MinDistance.java
 * 
 * Need to read leetcode solution, didn not realize this was a dp problem with longest common substring
 * 
 * How to understand this question:
 *      Need to find the minimum number of deletions required to make word1 equal to word2
 *      Suppose we compare the last 2 characters
 *          If they're the same, then no deletions necessary
 *              Then we can inspect the rest of the word
 *                  minDistance(word1, word2) = 0 + minDistance(word1 - 1, word2 - 1) (i.e. drop the last character)
 *                  Another way to look at it
 *                      "The number of deletions necessary will be equal to the number of deletions
 *                      that was necessary to make both words WITHOUT the last character equal"
 *          If they're not the same, then a deletion is required
 *              But where do you delete? There's two cases, either from word1 or word2
 *                  minDistance(word1 , word2) = 1 + min(minDistance(word1 - 1, word2), minDistance(word1, word2 - 1))
 *          From here we can build a 2d dp array based on these two rules
 * 
 *      Now in our DP array, we add one extra column and one extra row and column assuming the string was empty (see grid below)
 *          Fill in a 2D array from top left to bottom right
 *              dp[i][j] = min number of deletions to make word1[0 to i - 1 characters] equal to word2[0 to j - 1 characters]
 *          If the last characters are equal (word1[i] == word2[j])
 *              dp[i][j] = dp[i - 1][j - 1]
 *          If the last characters are not equal
 *              dp[i][j] = 1 + the min of dp[i - 1][j] and dp[i][j - 1] (above and to the left of the current dp index, which each represent one of the two possible last letter deletions)
 *          So for an example (~ means empty string)
 *                ~ s e a h o r s e
 *              ~ 0 1 2 3 4 5 6 7 8
 *              s 1 0 1 2 3 4 5 6 7
 *              h 2 1 2 3 2 3 4 5 6
 *              o 3 2 3 4 3 2 3 4 5
 *              r 4 3 4 5 4 3 2 3 4
 *              e 5 4 3 4 5 4 3 4 3
 *                  For example
 *                      To make sea equal to ~, we need 3 deletions
 *                      To make seah equal to sh, we need 2 deletions
 *                          But the endings are the same, so look at how many deletions were needed to make sea equal to s (2)
 *                      To make s equal to shore , we need 4 deletions
 *          Final answer is 3 (which is obvious)
 *      
 * Time Compleixty: O(word1 length * word2 length)
 *          
 */

class Solution {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        
        int[][] dp = new int[w1.length + 1][w2.length + 1];
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                else if (j == 0) {
                    dp[i][j] = i;
                }
                else if (w1[i - 1] == w2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[word1.length()][word2.length()];
    }
}