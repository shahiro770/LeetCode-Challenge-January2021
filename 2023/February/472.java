/**
 * Concatenated Words
 *
 * Top 71% (69ms)
 * 
 * Messed DP question
 *
 * Time Complexity: O(n ^ l) where l i the longest string length
 */

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        final Set<String> dictonary = new HashSet<>(Arrays.asList(words));
        final List<String> answer = new ArrayList<>();

        for(final String word : words){
            final int len = word.length();
            final boolean[] dp = new boolean[len+1];
            dp[0] = true;
            for(int i = 1; i <= len; i++){
                for(int j = (i == len ? 1 : 0); !dp[i] && j < i; j++){
                    dp[i] = dp[j] && dictonary.contains(word.substring(j,i));
                }
            }
            if(dp[len]){
                answer.add(word);
            }
        }
        return answer;
    }
}
