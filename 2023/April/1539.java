/*
 * Kth Missing Positive Number
 * 
 * Top 100% (0ms)
 * 
 * Might not seem like a binary search problem, but there's a trick. Notice how
 * at arr[i], the value may not match the index if there are positive numbers missing. In fact,
 * the number of positive numbers missing before arr[i] = arr[i] - i - 1 (try some examples to see).
 * 
 * With this knowledge, we can binary serach for the index right below the kth missing number,
 * adding k to it to get the answer.
 * 
 * Time complexity: O(lgn)
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

    k = 2
    2 3 4 7 11
    0 1 2 3 4 5
    L   M     H     missing = 1
          L M H     missing = 3
          LMH       missing = 3
    3 + 2 = 5 -> correct answer
*/