/*
 * Count Complete Tree Nodes
 * 
 * Top 100% (0ms)
 * 
 * Since the tree is complete, there is at most one subtree per depth where the following logic doesn't hold:
 * If the depth of the leftmost node and rightmost node are equal, then the tree has 2^n - 1 nodes,
 * where n is the depth of the tree.
 * 
 * This means at each depth (after the first), assuming the tree is full, half of the tree will be accounted for,
 * while the the node with the imbalance will need to be recounted, hence the lgn * lgn time complexity
 * as we will have to do this O(2lgn) depth comparison lgn times.
 * 
 * Time complexity: O(lgn * lgn)
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right =root.right;
        int leftDepth = 1;
        int rightDepth = 1;

        while (left != null) {
            left = left.left;
            leftDepth++;
        }
        while (right != null) {
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth) {
            return (int)Math.pow(2, rightDepth) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

/*
                            1
                2                      3
        4           5           6           7
    8       9   10      11   12     13    14     15

    1R = 2^2 - 1
    2R = 2^3 - 1
    1R 1L = 2^3 - 2
    1L = 2^
*/