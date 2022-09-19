/**
 * Pseudo-Palindromic Paths in a Binary Tree
 * 
 * September 2022
 * Top 98% (9ms)
 * 
 * Count the frequencies of each number occurring and then see if in the end you only have
 * at most one odd frequency. Otherwise you don't have a pseudo-palindrome.
 * 
 * The trick for efficiency is to make use of bit-wise operations rather than an array to store
 * the frequencies.
 * 
 * Time complexity: O(n)
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
    public int pseudoPalindromicPaths (TreeNode root) {
        int paths = 0;
        int count = 0;
        
        count += traverse(root, 0);
        
        return count;
    }
    
    public int traverse(TreeNode node, int path) {
        if (node != null) {
            // xor the bit at node.val's position
            // an even number of occurrences = 0, an odd number of occurrences = 1
            path ^= (1 << node.val);
            
            if (node.left == null && node.right == null) {
                // path == 0 means only even occurences across the path
                // path & (path - 1) being 0 means a single odd occurence across the path
                // e.g. in the path 131, the binary at that point would be 100
                // 100 & 011 == 000 
                // e.g. in the path 132, the binary  at that point would be 111
                // 111 & 110 == 110 
                if (path == 0 || (path & (path - 1)) == 0) {
                    return 1;
                }
                return 0;
            }

            return traverse(node.left, path) + traverse(node.right, path);  
        }
        
        return 0;
    }
}