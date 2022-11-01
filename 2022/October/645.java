/*
 * Set Mismatch
 * 
 * Do a count and then check the count
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int[] count = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            count[nums[i - 1]]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 2) {
                ans[0] = i;
            }
            if (count[i] == 0) {
                ans[1] = i;
            }
        }

        return ans;
    }
}