/**
 * Feb 2021 Day 2
 * Is the current node null? return null
 * Is the node's val greater than the maximum? Chop it off and attach the node's left branch
 * Is the node's val less than the minimum? Chop it off and attach the node's right branch
 *      The other branch will by definition have values larger/smaller than the maximum/minimum since it is a BST
 * Once the current node is good, repeat this process on its children if any.
 * 
 * Time complexity O(n) (worst case we go through the entire tree chopping off zig-zaggy nodes)
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        else if (root.val < low) {
            return trimBST(root.right, low , high);
        }
        
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        
        return root;
    }
}