/**
 * Path Sum
 * 
 * October 2022
 * Top 100% (0ms)  
 * 
 * Time complexity: O(n)
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return traverse (root, 0, targetSum);
    }

    public boolean traverse(TreeNode curr, int sum, int targetSum) {
        if (curr.left == null && curr.right == null) {
            return sum + curr.val == targetSum;
        }
        else {
            boolean resultLeft = false;
            boolean resultRight = false;
            if (curr.left != null) {
                resultLeft = traverse(curr.left, sum + curr.val, targetSum);
            }
            if (curr.right != null) {
                resultRight = traverse(curr.right, sum + curr.val, targetSum);
            }
            
            return (resultLeft || resultRight);
        }
    }
}