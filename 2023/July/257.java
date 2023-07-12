/*
 * Binary Tree Paths
 *
 * Top 100% (1ms)
 * 
 * Only catch here is with the stringbuilder you need to undo the path building as you go up and down the call stack.
 * Remove the number of digits from the length of the string builder as you do so.
 * 
 * Time Complexity: O(n) 
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
    ArrayList<String> sol = new ArrayList<String>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return sol;
        }
        traverse(root, new StringBuilder());

        return sol;
    }

    public void traverse(TreeNode node, StringBuilder path) {
        path.append(node.val);

        if (node.left != null) {
            path.append("->");
            traverse(node.left, path);
            path.setLength(path.length() - 2);
        }

        if (node.right != null) {
            path.append("->");
            traverse(node.right, path);
            path.setLength(path.length() - 2);
        }
        if (node.left == null && node.right == null) {
            sol.add(path.toString());
        }
        path.setLength(path.length() - countDigits(node.val));
    }

    public int countDigits(int num) {
        int length = 0;

        if (num < 0) {
            length += 1;
            num *= -1;
        }
        int temp = 1;
        while (temp <= num) {
            length++;
            temp *= 10;
        }
        return length;
    }
}