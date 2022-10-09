/*
 * 3Sum
 * 
 * August 2022
 * Top 97% (3ms)
 *
 * Just move the pointers inward and see if you ever find a better answer.
 *
 * Time complexity: O(n) 
*/

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int length = right - left;
        int maxWater = 0;

        while (left < right) {      
            // System.out.println(length);
            maxWater = Math.max(maxWater, Math.min(height[left], height[right]) * length);
            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
            length--;
        }
        return maxWater;
    }
}