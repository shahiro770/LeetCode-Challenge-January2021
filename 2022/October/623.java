/**
 * Add One Row to Tree
 * 
 * October 2022
 * Top 100% (0ms)  
 * 
 * DFS until you get to the desired row, then do some easy splicing.
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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }

        traverse(root, null, val, depth - 2);

        return root;
    }

    public void traverse(TreeNode curr, TreeNode parent, int val, int depth) {
        if (curr != null) {
            if (depth == 0) {
                TreeNode newLeft = new TreeNode(val, curr.left, null);
                curr.left = newLeft;
                TreeNode newRight = new TreeNode(val, null, curr.right);
                curr.right = newRight; 
            }
            else {
                if (curr.left != null) {
                    traverse(curr.left, curr, val, depth - 1);
                }
                if (curr.right != null) {
                    traverse(curr.right, curr, val, depth - 1);
                }
            }
        }
    }
}