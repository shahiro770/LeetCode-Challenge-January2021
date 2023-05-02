/*
 * Binary Tree Postorder Traversal
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
    List<Integer> sol;

    public List<Integer> postorderTraversal(TreeNode root) {
        sol = new ArrayList<Integer>();
        traverse(root);

        return sol;
    }

    public void traverse(TreeNode node) {
        if (node != null) {
            traverse(node.left);
            traverse(node.right);

            sol.add(node.val);
        }
    }
}