/*
 * Minimum Distance Between BST Nodes
 * 
 * Top 100% (0ms)
 * 
 * I messed this one up and had to look at a solution. RIP easy leetcode easy streak.
 * 
 * The minimum difference is going to be between the current node and one of its children.
 * I mistakenly thought it could be between the largest leftNode and the smallest rightNode,
 * however if that were the case, the root node of the tree would be closer to either of those values
 * than between those values themselves. Think of it like a sorted array; the smallest difference will 
 * be between adjacents.
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
    int res = Integer.MAX_VALUE; 
    int previous = -1;

    public int minDiffInBST(TreeNode root) {
        if (root.left != null) {
            minDiffInBST(root.left);
        }
        if (previous != -1) {
            res = Math.min(res, root.val - previous);
        }
        previous = root.val;
        if (root.right != null) {
            minDiffInBST(root.right);
        }
        return res;
    }
}