/*
 * Subtree of Another Tree
 *
 * Top 74% (4ms)
 * 
 * Time Complexity: O(n * m) as we could potentially check the entire subtree of m nodes
 * n times 
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
    boolean sol = false;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        traverseForMatch(root, subRoot);

        return sol;
    }

    public void traverseForMatch(TreeNode node, TreeNode subRoot) {
        if (node != null) {
            if (node.val == subRoot.val) {
                if (traverseForSubtree(node, subRoot) == true) {
                    sol = true;
                }
            }
            if (sol == false) {
                traverseForMatch(node.left, subRoot);
                traverseForMatch(node.right, subRoot);
            }
        }
    }

    public boolean traverseForSubtree(TreeNode node, TreeNode subNode) {
        if (node == null && subNode == null) {
            return true;
        }
        else if (node != null && subNode != null) {
            if (node.val == subNode.val) {
                boolean leftMatch = traverseForSubtree(node.left, subNode.left);
                boolean rightMatch = traverseForSubtree(node.right, subNode.right);
                if (leftMatch == true && rightMatch == true) {
                    return true;
                }
            }
        }

        return false;
    }
}