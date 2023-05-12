/*
 * Check Completeness of a Binary Tree
 *
 * Top 100% (0ms)
 *
 * Find the height of the leftmost node. From there traverse the rest of the tree to the leafs in order
 * from left to right:
 * 1) If we find a null node before reaching the target height, its not complete
 * 2) If we reach a null node for the first time when reaching the target height, assume its the rest
 * of the nodes in the row will be null (i.e. last level is as far left as possible)
 * 3) If we reach a non-null node when reaching the target height
 *      3.1) If 2) was already checked, its not complete
 *      3.2) If there are more nodes after, its not complete
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
    boolean foundRightMost = false;
    int reqDepth = 0;

    public boolean isCompleteTree(TreeNode root) {
        TreeNode leftMost = root;
        while (leftMost != null) {
            leftMost = leftMost.left;
            reqDepth++;
        }
        traverse(root, 1);


        return sol;
    }

    public void traverse(TreeNode node, int depth) { 
        if (depth == reqDepth) {
            if (node != null && (foundRightMost == true || node.left != null || node.right != null)) {
                sol = false;
            }
            else if (node == null && foundRightMost == false) {
                foundRightMost = true;
            }
        }
        else {
            if (node == null) {
                sol = false;
            }
            else {
                traverse(node.left, depth + 1);
                traverse(node.right, depth + 1);
            }
        }
    }
}