/*
 * Maximum Difference Between Node and Ancestor
 * 
 * Top 100% (0ms)
 * 
 * Since the tree is not a BST, you have to check every node. Combine this fact
 * with that its the absolute difference, you need to pass the min and max valued ancestors as you
 * descend down as either could potentially give the maximum difference (e.g. 1 and 10 are the min
 * and max so far on a path, 9 as the current node would give us 8 as the max diff, not 1)
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
    int ans;

    public int maxAncestorDiff(TreeNode root) {
        traverse(root, root.val, root.val);

        return ans;
    }

    public void traverse(TreeNode curr, int maxSoFar, int minSoFar) {
        if (curr != null) {
            int maxDiffHere = Math.max(Math.abs(curr.val - maxSoFar), Math.abs(curr.val - minSoFar));
            ans = Math.max(maxDiffHere, ans);
            if (curr.val < minSoFar) {
                minSoFar = curr.val;
            }
            else if (curr.val > maxSoFar) {
                maxSoFar = curr.val;
            }

            traverse(curr.left, maxSoFar, minSoFar);
            traverse(curr.right, maxSoFar, minSoFar);
        }
    }
}