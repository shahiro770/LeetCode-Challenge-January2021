class Solution {
    public int trap(int[] height) {
        int trappedWater = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        
        int currLeft = 0;
        int currRight = 0;
        
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