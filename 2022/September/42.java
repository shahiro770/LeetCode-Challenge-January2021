/*
 * Trapping rainWater
 * 
 * September 2022
 * Top 99% (1ms)
 * 
 * The amount of water any given x index can hold will depend on the minimum height of the
 * adjacent walls and the height of x. e.g. [2,0,1] can hold 1 point of water at x = 1.
 * 
 * This may seem simple but then you realize this simple logic doesn't work when the "trapping"
 * walls are further out. e.g. [3,1,1,3,1,2]. How do you determine how much water can be held at x = 2?
 * 
 * Luckily the solution is intuitive; just record the highest wall you've seen from the left of x,
 * as well as from the right. As long as we know the height of the trapping walls, we can apply
 * the "minimum height of the adjacent walls" logic.
 * 
 * The minimum height of the left/right wall less the height of x will tell 
 * us how much water is trapped (ignoring negatives). e.g. for [3,1,1,3,1,2]
 * 
 * Max Left:  [0,3,3,3,3,3]
 * Max Right: [3,3,3,2,2,0]
 * Min L/R :  [0,3,3,2,2,0]
 * Water:     [0,2,2,0,1,0]
 * 
 * So a total of 5 units of water will be trapped.
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public int trap(int[] height) {
        int trappedWater = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        
        for (int i = 0; i < height.length; i++) {
            int waterSum = Math.min(maxLeft[i], maxRight[i]) - height[i];
            trappedWater += waterSum > 0 ? waterSum : 0;
        }
        
        return trappedWater;
    }
}