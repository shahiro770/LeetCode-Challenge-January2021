/**
 * Two Sum IV - Input is a BST
 *
 * October 2022
 * Top 86% (4ms)  
 * 
 * Hashtable to find the missing half as you traverse
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
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    boolean answer = false;

    public boolean findTarget(TreeNode root, int k) {
        traverse(root, k);
        return answer;
    }

    public void traverse(TreeNode node, int k) {
        if (node != null) {
            if (map.containsKey(k - node.val)) {
                answer = true;
            }
            else {
                map.put(node.val, 0);
                traverse(node.left, k);
                traverse(node.right, k);
            }
        }
    }
}