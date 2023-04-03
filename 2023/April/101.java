/**
 * Symmetric Tree
 * 
 * Top 100% (0ms)
 * 
 * As long as you pass both compared nodes to the function, you can traverse the left and right sides of
 * the tree at the same time, constantly comparing the node sin question. Another option is to put the
 * values in a list for both sides (traversing the right in flipped order) and then
 * comparing, but this is 1 ms slower.
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
    public boolean isSymmetric(TreeNode root) {
        return checkTree(root.left, root.right);
    }
    public boolean checkTree(TreeNode p, TreeNode q){
        if (p == null || q == null) {
            return p == q;
        }
        if (p.val == q.val) {
            return checkTree(p.left, q.right) && checkTree(p.right, q.left);
        }
        
        return false;
    }
}