/*
 * Shuffle the Array
 *
 * Top 100% (0ms)
 * 
 * Time Complexity: O(n)
 */

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int s[] = new int[n * 2];
        
        for (int i = 0; i < n; i++) {
            s[i * 2] = nums[i];
            s[i * 2 + 1] = nums[n + i];
        }
        
        return s;
    }
}