/**
 * Feb 2021 Day 17
 * Absolutely the easiest sliding window imaginable.
 *      Start from the far left and far right.
 *      The only way the amount of water contained can increase is if the the min height of both sides goes up.
 *      Keep moving inward until left == right
 * 
 * Time Complexity: O(n)
*/

class Solution {
    public int maxArea(int[] height) {
        int mostWater = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            int water = Math.min(height[start], height[end]) * (end - start);
            if (water > mostWater) {
                mostWater = water;
            }
            if (height[start] < height[end]) {
                start++;
            }
            else {
                end--;
            }
        }
        
        return mostWater;
    }
}