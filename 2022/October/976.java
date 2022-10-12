/**
 * Largest Perimeter Triangle
 * 
 * Top 97% (7ms)
 * 
 * Sort the array then go in descending order, trying all triplets until one works  (or none of them do).
 * How to test for valid triangles? Two ways I know:
 * 1) Check if the largest side has length less than the other two sides combined (a result of pythagorean theorem)
 * 2) Use heron's formula and see if the area prior to being square rooted is greater than 0 (otherwise invalid)
 * 
 * I used herons cause it looked cool
 * 
 * Time Complexity: O(nlgn)
 * */

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i - 2 >= 0; i--) {
            double s = (double)(nums[i] + nums[i - 1] + nums[i - 2]) / 2;
            double a  = s * (s - nums[i]) * (s - nums[i - 1]) * (s - nums[i - 2]);
            if (a > 0) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }

        return 0;
    }
}