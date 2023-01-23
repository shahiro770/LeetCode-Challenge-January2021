/*
 * Same Tree
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

    boolean isSame = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        traverse(p, q);
        return isSame;
    }

    public void traverse(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val == q.val) {
                traverse(p.left, q.left);
                traverse(p.right, q.right);
            }
            else {
                isSame = false;
            }
        }
        else if ((p == null && q != null) || (p != null && q == null)) {
            isSame = false;
        }
    }
}