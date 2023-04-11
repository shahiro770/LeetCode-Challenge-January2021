/*
 * Invert Binary Tree
 * 
 * Top 100% (0ms)
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
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            invertHelper(root);
        }
        return root;
    }
    
    public void invertHelper(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        if (node.left != null) {
            invertTree(node.left);
        }
        if (node.right != null) {
            invertTree(node.right);
        }
    }
}