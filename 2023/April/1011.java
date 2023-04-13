/**
 * Capacity To Ship Packages Within D Days
 * 
 * Top 76% (10ms)
 * 
 * Annoying question to optimize.
 * 
 * You wouldn't think it'd be required to loop through all of the weights as you binary search for the
 * optimal weight, but that is the correct solution and it feels weight.
 * 
 * Time Complexity: O(nlgn) 
 */

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < weights.length; i++) {
            right += weights[i];
        }
        int mid;
        int minWeight = right;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (isPossible(weights, days, mid)) {
                minWeight = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return minWeight;
    }

    private boolean isPossible(int[] weights, int days, int mid) {
        /*
            Start with midDays = 1, due to constraints at minimum one ship will be needed,
            and if cargoSpace > 0 when the loop ends but another day hasn't be registered, this is
            covered as well
         */
        int midDays = 1;    

        int cargoSpace = 0;
        for (int i = 0; i < weights.length; i++) {
            if (cargoSpace + weights[i] <=  mid) {
                cargoSpace += weights[i];
            }
            else {
                midDays++;
                cargoSpace = weights[i];
                if (midDays > days || mid < weights[i]) {
                    return false;
                }
            }               
        }

        return true;
    }
}