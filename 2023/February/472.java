/**
 * Concatenated Words
 *
 * Top 53% (81)
 * 
 * Messed DP question. Since the restriction is that it has to be comprised of AT LEAST two other strings in the dictionary,
 * your dp logic needs to be per string as follows:
 * 1) iterate through the string
 * 2) for each index i , try substrings from 0 to i and check if they are in the dictionary
 * 3) if they are, mark in your dp that there are words in the dictionary that form a concatenated string up to i
 * 4) if dp[word length] is true, then you got a concatenated word, otherwise add it to the dictionary
 * 
 * Notice how with 4), it requires 2)/3) evaluating to true possibly multiple times (a concatenation could be 3+ words)
 * 
 * Some edge cases and concerns:
 * 1) This solution relies on sorting the words first in length, so you can build the dictionary up (smaller words
 * cannot be concatenations of anything of lesser size). The faster solutions for this question somehow avoid sorting by
 * starting with the dictionary set full of all strings and removing the concatenations, but I tried this and it didn't work
 * 2) You need to do the dp[n + 1] trick so dp[0] initalizes to 0. For some reason empty string is valid in this, and this catches
 * that edge case
 * 3)
 *
 * Time Complexity: O(n ^ l) where l i the longest string length
 */

 class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> dict = new HashSet<>();
        List<String> sol = new ArrayList<>();

        Arrays.sort(words, (a, b) -> {
            return a.length() - b.length();
        });

        for ( String word : words){
            int len = word.length();
            boolean[] dp = new boolean[len + 1]; 
            dp[0] = true;
            for (int i = 1; i <= len; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] == true) {    // don't bother testing if word[j] couldn't follow another valid word
                        if (dict.contains(word.substring(j, i))) {
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }
            if (dp[len] == true) {
                sol.add(word);
            }
            else {
                dict.add(word);
            }
        }
        return sol;
    }
}
