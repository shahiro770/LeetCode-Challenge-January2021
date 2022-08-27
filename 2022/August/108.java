/**
 * Convert Sorted Array to Binary Search Tree
 * Aug 2022 Day 10
 * Top 100% (0ms)
 * 
 * Keep taking the middle value of the array. Do the middle of the elements
 * to the left and the middle of the elements to the right to determine what comes next.
 * End result will be the tree being balanced
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {        
        return helper(nums, 0, nums.length - 1);
    }
    
    public TreeNode helper(int[] nums, int low, int high) {
        if (low <= high) {
            
            int mid = (low + high) / 2;
            
            TreeNode newNode = new TreeNode(nums[mid]);
            
            newNode.left = helper(nums, low, mid - 1);
            newNode.right = helper(nums, mid + 1, high);
            
            return newNode;
        }
        
        return null; 
    }
}