/*
 * Sum Root to Leaf Numbers
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
    int totalSum = 0;

    public int sumNumbers(TreeNode root) {
        traverse(root, 0);

        return totalSum;
    }

    public void traverse(TreeNode node, int val) {
        if (node != null) {
            val = val * 10 + node.val;

            if (node.right == null && node.left == null) {
                totalSum += val;
            }
            else {
                traverse(node.left, val);
                traverse(node.right, val);
            }
        }
    }
}