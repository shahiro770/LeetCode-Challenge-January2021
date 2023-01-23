/*
 * Binary Tree Preorder Traversal
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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> sol = new ArrayList<Integer>();

        traverse(root, sol);

        return sol;
    }

    public void traverse(TreeNode node, ArrayList<Integer> list) {
        if (node != null) {
            list.add(node.val);
            traverse(node.left, list);
            traverse(node.right, list);
        }
    }
}