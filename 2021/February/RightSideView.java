
/**
 * Feb 2021 Day 6
 * Breadth first search the tree, but "break" each search by depth
 *      Since BFS will add all nodes of a given depth at once, we just need to know when the last node in a depth is being added
 *          This will give us the right most node
 *          Also be sure to maintain order (always add left then right so future depths read from left to right)
 * 
 * O(n) for time and space since we visit each node in the tree
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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> visiting = new LinkedList<TreeNode>();
        ArrayList<Integer> solution = new ArrayList<Integer>();
        
        if (root == null) {
            return solution;
        }
        visiting.add(root);
        
        while (visiting.isEmpty() == false) {
            int size = visiting.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = visiting.poll();
                if (i == size - 1) {
                    solution.add(t.val);
                }
                
                if (t.left != null) {
                    visiting.add(t.left);
                }
                if (t.right != null) {
                    visiting.add(t.right);
                }
            }
        }
        
        return solution;
    }
}