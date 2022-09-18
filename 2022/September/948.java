/**
 * Bag of Tokens
 * 
 * September 2022
 * Top 82% (4ms)
 * 
 * Since you can flip the tokens in any order, sort them first.
 * Notice how it is always optimal to spend the minimum power to get score > 0
 * and then use that score to convert the highest value token available for more power.
 * Keep doing this until you can't get any more score.
 * 
 * Time Complexity: O(n)
 */ 

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        
        Arrays.sort(tokens);
        
        int left = 0;
        int right = tokens.length - 1;
        
        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                left++;
                score++;
            }
            // edge case where you get left = right, you do not want to spend any power to lose 
            // 1 point of score at the very end (e.g. [100, 200] with 150 power)
            else if (score > 0 && left != right) {
                power += tokens[right];
                right--;
                score--;
            }
            else {
                break;
            }
        }
        
        return score;
    }
}