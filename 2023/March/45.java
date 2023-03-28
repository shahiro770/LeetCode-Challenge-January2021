/*
 * Jump Game II
 *
 * Top 99% (1ms)
 * 
 * You can view the problem like a tree, where each depth is composed of all the nodes that could
 * be reached from nodes on the previous node. The number of jumps is equal to the depth of the tree.
 * 
 * This logic can be simplified greatly; the "last node" on a given depth will be the farthest spot
 * you could reach from the previous "last node" (starting at index 0).
 * 
 * */

class Solution {
    public int jump(int[] nums) {
        int farthest = nums[0];
        int jumps = 0;
        int currentEnd = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + i > farthest) {
                farthest = nums[i] + i;
            }
            if (i == currentEnd && i != nums.length - 1) {
                currentEnd = farthest;
                jumps++;
            }
        }

        return jumps;
    }
}
