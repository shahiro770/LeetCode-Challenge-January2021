/*
 * Kth Smallest Element in a BST
 *
 * Top 100% (0ms)
 * 
 * In order traversal means we read the tree from least to greatest.
 * Return the kth value in that order.
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
    int visitedCount = 0;
    int sol;

    public int kthSmallest(TreeNode root, int k) {
       if (root != null && visitedCount < k) {
           kthSmallest(root.left, k);
           
           visitedCount++;
           if (visitedCount == k) {
               sol = root.val;
           }

           kthSmallest(root.right, k);
       }

       return sol;
    }
}