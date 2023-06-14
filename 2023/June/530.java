/*
 * Minimum Absolute Difference in BST
 *
 * Top 56% (1ms) bruh
 * 
 * In order traversal (left, root, right) is the way to go here, but there's a(n) (obvious) catch; remember
 * the last node that was visited, as that will be the node you subtract the next from. The whole point of
 * in-order traversal of a BST is to view the tree like a sorted array, which solves this problem.
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
    int minDiff = Integer.MAX_VALUE;
    Integer prev = null;
    
    public int getMinimumDifference(TreeNode root) {
        setMinimumDifference(root);
        return minDiff;
    }

    public void setMinimumDifference(TreeNode root) {
        if (root != null) {
            setMinimumDifference(root.left);

            if (prev != null) {
                minDiff = Math.min(root.val - prev, minDiff);
            }
            prev = root.val;

            setMinimumDifference(root.right);
        }
    }
}