/*
 * Binary Tree Level Order Traversal
 *
 * Top 89.3% (1ms)
 * 
 * Since we can just index the level in our solution, just descend left then right.
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> sol = new ArrayList<List<Integer>>();

        traverse(root, 0, sol);

        return sol;
    }

    public void traverse(TreeNode node, int depth, ArrayList<List<Integer>> sol) {
        if (node != null) {
            // System.out.println(sol.size() + " " + depth);
            if (sol.size() == depth) {
                
                sol.add(new ArrayList<Integer>());
            }

            sol.get(depth).add(node.val);
            traverse(node.left, depth + 1, sol);
            traverse(node.right, depth + 1, sol);
        }
    }
}