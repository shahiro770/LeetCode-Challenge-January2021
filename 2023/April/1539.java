/*
 * Kth Missing Positive Number
 * 
 * Top 100% (0ms)
 */

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length;
        int mid;

        while (low < high) {
            mid = low + (high - low) / 2;
            if (arr[mid] - mid - 1 < k) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        return low + k;
    }
}

/*
    [2,3,4,7,11]
           ^
           3
         4 = index = 2 -> 1 missing number before it
         7 = index = 3 -> 7 - 3 - 1 = 3 numbers before it are missing
*/