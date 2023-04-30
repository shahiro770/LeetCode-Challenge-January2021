/*
 * Minimum Depth of Binary Tree
 * 
 * Top 82% (2ms)
 * 
 * Time Complexity: O(n)
 * */

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
    int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root, 1);

        return minDepth;
    }

    private void traverse (TreeNode node, int currDepth) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                if (currDepth < minDepth) {
                    minDepth = currDepth;
                }
            }
            if (currDepth < minDepth) {
                traverse(node.left, currDepth + 1);
                traverse(node.right, currDepth + 1);
            }
        }
    }
}