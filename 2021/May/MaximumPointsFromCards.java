/**
 * May 2021 Day 11
 * 
 * Bottom 48% but its literally 2ms vs 1ms (cause best solution is O(n) and this is O(2n))
 * 
 * You  get a score for each card you remove but you can only remove cards at the end and can only remove k cards.
 * At first it seems like some kind of dp optimization question cause it is, but there's a really logical way to cheese it
 * and get what i'd say is still a great solution. 
 * 
 * Start by expanding a window of removed cards from left to right
 *      Once you can't anymore, shrink the window on the left and grow one from the right side
 *      This tests all combinations and just maintain the maxscore as the highest sum you observe
 * 
 * Time complexity: O(n)
 */

class Solution {
    public int maxScore(int[] cardPoints, int k) {           
        int sum = 0;
        int score = 0;
        int left = 0;
        int right = cardPoints.length - 1;
        boolean goingRight = true;
        
        for (int i = 0; i < k * 2; i++) {
            if (goingRight == true) {
                sum += cardPoints[left];
                left++;
                score = Math.max(sum, score);
            }
            if (goingRight == false) {
                sum += cardPoints[right];
                right--;
                left--;
                sum -= cardPoints[left];
                score = Math.max(sum, score);
            }
            if (left == k) {
                goingRight = false;
            }
        }
        
        return max;
    }
}