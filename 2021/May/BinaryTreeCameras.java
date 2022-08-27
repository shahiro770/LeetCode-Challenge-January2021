/**
 * May 2021 Day 16
 * 
 * Literally bottom tier cause I used the leetcode solution (this question was hard)
 * 
 * So supposed you start at the bottom of the tree. Evaluate the bottom most nodes as covered by a camera.
 * From there as you work up you need to realize that if a node's children are covered, and it isn't,
 * we can just move the camera up oneto cover the node and its parent in addition to its kids.
 *      This means instead of ever assigning cameras to the bottom depth, we basically only start assigning one level up
 * 
 * As an example, suppose we had a tree like
 * 
 *                                  1   
 *                  2                               3
 *          4               5               6               7
 *      8        9      10      11      12      13      14      15
 * 
 *      Take the 2 subtree
 *       From the recursive calls, (using a dfs), 4 is first to get a camera, assigning one to 2 in the process
 *          5 gets a camera in a similar process
 *      Similarly 3 subtree also gets 2 cameras to cover it
 *          Fianlly one gets assigned a camera, meaning it took 5 cameras to cover this entire tree
 * 
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
    int result;
    Set<TreeNode> cammed;
    
    public int minCameraCover(TreeNode root) {
        cammed = new HashSet<TreeNode>();
        cammed.add(null);   // this way nulls are always treated as covered (clean hack)
        result = 0;
        
        cover(root, null);
        
        return result;
    }
    
    public void cover(TreeNode node, TreeNode parent) {
        if (node != null) {
            cover(node.left, node);
            cover(node.right, node);
            
            /**
             * Edge case: If the parent is null (i.e. the root) and the current node isn't covered
             * then we must add a camera, otherwise just check if the children are not covered to debate adding a camera
             */
            if ((parent == null && cammed.contains(node) == false)
            || cammed.contains(node.left) == false
            || cammed.contains(node.right) == false) {
                result++;
                cammed.add(node.left);
                cammed.add(node.right);
                cammed.add(node);
                cammed.add(parent);
            }
        } 
    }
}