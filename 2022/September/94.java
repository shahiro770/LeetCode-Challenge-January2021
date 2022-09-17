/**
 * Binary Tree Inorder Traversal
 * 
 * September 2022
 * Top 100% (0ms)  
 * 
 * Inorder traversal (left, center, right)
 * Iterative for curious: https://leetcode.com/problems/binary-tree-inorder-traversal/discuss/31213/Iterative-solution-in-Java-simple-and-readable
 * 
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> sol = new ArrayList<Integer>();
        
        traverse(root, sol);    
        return sol;
    }
    
    private void traverse(TreeNode node, List<Integer> sol) {
        if (node != null) {
            
            traverse(node.left, sol);
            sol.add(node.val);
            traverse(node.right, sol);
        }
    }
}