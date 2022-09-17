/**
 * Count Good Nodes in Binary Tree
 * 
 * September 2022
 * Top 100% (2ms)
 * 
 * Keep track of the largest node seen as you traverse down the tree. Anyone who is bigger 
 * than the largest seen so far becomes the largest seen so far in the path and is a good node.
 */ 
/**
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
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }
    
    public int goodNodes(TreeNode node, int largestSeenSoFar) {
        if (node != null) {
            if (node.val >= largestSeenSoFar) {
                return 1 + goodNodes(node.left, node.val) + goodNodes(node.right, node.val);
            }
            return goodNodes(node.left, largestSeenSoFar) + goodNodes(node.right, largestSeenSoFar);
        }
            
        return 0;
    }
}