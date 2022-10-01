/*
 * Path Sum II
 * 
 * September 2022
 * Top 100% (1ms)
 * 
 * 
 * Pass a list down through your traversal and check if the sum equals the target
 * upon reaching a leaf node.
 * 
 * Time complexity: O(n)
 * 
 * */

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<List<Integer>> sol = new ArrayList<List<Integer>>();
        
        if (root != null) {
            traverse(root, new ArrayList<Integer>(), 0, sol, targetSum);
        }
        
        return sol;
    }
    
    public void traverse(TreeNode curr, ArrayList<Integer> path, int sum, ArrayList<List<Integer>> sol, int targetSum) {
        sum += curr.val;
        path.add(curr.val);

        if (curr.left == null && curr.right == null) {
            if (sum == targetSum) {
                sol.add((ArrayList<Integer>)path.clone());
            }
        }
        else {
            if (curr.left != null) {
                traverse(curr.left, path, sum, sol, targetSum);
                path.remove(path.size() - 1);
            }
            if (curr.right != null) {
                traverse(curr.right, path, sum, sol, targetSum);
                path.remove(path.size() - 1);
            }
        }
        
    }
}