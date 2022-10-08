/**
 * 3Sum Closest
 * 
 * October 2022
 * Top 90% (60ms)  
 * 
 * For each number, do a sliding window in front of it.
 * Since you can sort the array, 
 * if the sum of current number + left + right is less than the target, move the left up
 * otherwise move the right down.
 * 
 * Time complexity: O(nlogn + n^2)
 * */

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int left = i + 1;  
            // always make the window in front, since the previous combinations
            // will already have been used up
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[i] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }
                if (sum == target) {
                    return sum;
                }
                if (sum < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
       
        return closest;
    }
}
/*
Target: 6
Array: [-4,-1,1, 2]
              ^
-1
Current Subset: 
-4, 1, 2
    ^  ^
Closest: 
2
*/
