/*
 * Balanced Binary Tree
 * 
 * Top 93% (1ms)
 * 
 * Time Complexity: O(n) 
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
    boolean sol = true;
    
    public boolean isBalanced(TreeNode root) {
        traverse(root, 0);
        return sol;
    }

    public int traverse(TreeNode node, int depth) {
        if (node != null) {
            int leftHeight = traverse(node.left, depth + 1);
            int rightHeight = traverse(node.right, depth + 1);

            if (Math.abs(leftHeight - rightHeight) > 1) {
                sol = false;
            }

            return Math.max(leftHeight, rightHeight);
        }

        return depth;        
    }
}