/**
 * Maximize the Confusion of an Exam
 *
 * Top 80% (15ms)
 * 
 * Fairly easy sliding window, though I probably coulda wrote this in a more condensed way.
 * Expand the window as long as the smaller of T/F can be covered by k replacements. Once this isn't true, slide up 
 * the rear. Only catch is during the sliding process, it may become the case that the larger of T/F is no longer larger,
 * to the point where it could be covered by k instead. Stop the sliding in this case.
 * 
 * Time Complexity: O(n)
 * */

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int tCount = 0;
        int fCount = 0;
        int left = 0;
        int right = 0;
        int n = answerKey.length();
        int maxConfusion = 0;

        while (right < n) {
            char curr = answerKey.charAt(right);
            right++;

            if (curr == 'T') {
                tCount++;
            }
            else if (curr == 'F') {
                fCount++;
            }

            if (tCount >= fCount) {
                if (fCount <= k) {
                    maxConfusion = Math.max(maxConfusion, tCount + fCount);
                }
                else {
                    while (fCount > k) {
                        char toDel = answerKey.charAt(left);
                        left++;
                        if (toDel == 'T') {
                            tCount--;
                        }
                        else if (toDel == 'F') {
                            fCount--;
                        }
                        if (tCount <= k || fCount <= k) {
                            maxConfusion = Math.max(maxConfusion, tCount + fCount);
                            break;
                        }
                    }
                }
            }
            else if (fCount >= tCount) {
                if (tCount <= k) {
                    maxConfusion = Math.max(maxConfusion, tCount + fCount);
                }
                else {
                    while (tCount > k) {
                        char toDel = answerKey.charAt(left);
                        left++;
                        if (toDel == 'T') {
                            tCount--;
                        }
                        else if (toDel == 'F') {
                            fCount--;
                        }
                        if (tCount <= k || fCount <= k) {
                            maxConfusion = Math.max(maxConfusion, tCount + fCount);
                            break;
                        }
                    }
                }
            }
        }

        return maxConfusion;
    }
}