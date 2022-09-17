/**
 * Binary Tree Pruning
 * 
 * September 2022
 * Top 100% (0ms)  
 * 
 * Pseudo-DFS. For all nodes that aren't the root, check its left and right children.
 * If neither of them are the roots of subtrees with 1s in them, set them as null.
 * 
 * Time complexity: O(n) 
 * 
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
    public TreeNode pruneTree(TreeNode root) {
        if (dfs(root) == false) {
            return null;
        }
        
        return root;
    }
    
    private boolean dfs(TreeNode node) {
        if (node != null) {
            boolean isLeft1 = dfs(node.left);
            boolean isRight1 = dfs(node.right);
            if (isLeft1 == false) {
                node.left = null;
            } 
            if (isRight1 == false) {
                node.right = null;
            }
            
            // if the node's value is 1, or one of its children have a 1, the node can be kept
            return node.val != 0 || isLeft1 == true || isRight1 == true;    
        }
        
        return false; // base case for no children
    }
}