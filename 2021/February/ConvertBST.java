/**
 * Feb 2021 Day 9
 * 
 * Top 100% woooooo.
 * Basically pre order reversal from greatest to least, updating the values 
 * as you go.
 * 
 * O(n) since each node is visited at most twice
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
    int total = 0;
    
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        setGreater(root);
        
        return root;
    }
    
    public void setGreater(TreeNode node) {
        if (node.right == null && node.left == null) {
            total += node.val;
            node.val = total;     
        }
        else {
            if (node.right != null) {
                setGreater(node.right);
            }
            total += node.val;
            node.val = total;
            if (node.left != null) {
                setGreater(node.left);
            }
        }
    }
}