/**
 * Lowest Common Ancestor of a Binary Search Tree
 * Aug 2022 Day 12
 * Top 89% (5ms)
 * 
 * You have three cases:
 * 1) The current node has a value between p and q (inclusive). This must be the lowest common ancestor
 * because its a binary search tree
 * 2) Both p and q have values greater than or equal to the current node. Test the right child
 * 3) Both p and q have values less than or equal to the current node. Test the left child
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traverse(root, p , q);
    }
    
    public TreeNode traverse(TreeNode node, TreeNode p, TreeNode q) {
        if ((p.val >= node.val && q.val <= node.val)
        || (p.val <= node.val && q.val >= node.val)) {
            return node;
        }
        
        if (node.right != null && p.val >= node.val && q.val >= node.val) {
            return traverse(node.right, p, q);
        }
        if (node.left != null) {
            return traverse(node.left, p , q);
        }
        return null;
    }
}