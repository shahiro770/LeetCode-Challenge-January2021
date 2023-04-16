/**
 * Edit Distance
 * 
 * Top 89% (4ms)
 * 
 * Had to go with the base solution for this one. (https://en.wikipedia.org/wiki/Levenshtein_distance
 * is cool). Observe the following (starting from the end of the word and moving to the front,
 * could go the other way but then you have to type a little more by checking .length() every time)
 * 
 * At any given index for both words where the characters are different, 
 * we have three operations: replace, delete, and insert
 * 
 * 1) Doing the replace operation guarantees both characters at word1[index1] and word2[index2] are the same.
 * We can move the index up for both then and look at the next character.
 * 
 * 2) Inserting a character into word1 to match the one at word2 means we can move on to the next character
 * in word2, but the character at index1 may still be wrong, so index1 doesn't move up
 * 
 * 3) Removing a character from word1 means index1 moves up, while index2 doesn't, as word1 still might not match
 * (removal doesn't guarantee word1 at the new index1 matches word2 at index2)
 * 
 * Now between the above three operations, there are gonna be some repeated states, so a simple memoization
 * to know what the answer is at a given state saves us time from going through the whole word multiple times.
 * At most, we'll have n * m states, which gives us the time complexity
 * 
 * Time Complexity: O(n * m) 
 */

class Solution {
    Integer[][] dp;
    String word1;
    String word2;

    public int minDistance(String word1, String word2) {
        // makes it easier to not have to populate dp if we use Integer to default to null
       dp = new Integer[word1.length() + 1][word2.length() + 1];
       this.word1 = word1;
       this.word2 = word2;

         return minDistance(word1.length(), word2.length());
    }

    public int minDistance(int index1, int index2) {
        if (index1 == 0) {
            return index2;
        }
        else if (index2 == 0) {
            return index1;
        }
        if (dp[index1][index2] != null) {   
            return dp[index1][index2];
        }

        int minEditDistance = 0;
        if (word1.charAt(index1 - 1) == word2.charAt(index2 - 1)) {
            minEditDistance = minDistance(index1 - 1, index2 - 1);
        }
        else {
            int insertOp = minDistance(index1, index2 - 1);
            int deleteOp = minDistance(index1 - 1, index2);
            int replaceOp = minDistance(index1 - 1, index2 - 1);

            minEditDistance = Math.min(Math.min(insertOp, deleteOp), replaceOp) + 1;
        }
        dp[index1][index2] = minEditDistance;
        return minEditDistance;
    }
}