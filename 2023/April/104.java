/*
 * Maximum Depth of Binary Tree
 * 
 * Top 100% (0ms)
 * 
 * Time complexity: O(n)
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
    int sol = 0;

    public int maxDepth(TreeNode root) {
        traverse(root, 1);
        return sol;
    }

    private void traverse(TreeNode node, int currDepth) {
        if (node != null) {
            sol = Math.max(sol, currDepth);
            traverse(node.left, currDepth + 1);
            traverse(node.right, currDepth + 1);
        }
    }
}