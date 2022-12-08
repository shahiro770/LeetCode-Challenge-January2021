/**
 * Leaf-Similar Tree
 * 
 * Top 100% (0ms)
 * 
 * Traverse left then right
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> seq1 = new ArrayList<Integer>();
        ArrayList<Integer> seq2 = new ArrayList<Integer>();

        traverse(root1, seq1);
        traverse(root2, seq2);

        if (seq1.size() != seq2.size()) {
            return false;
        }

        for (int i = 0; i < seq1.size(); i++) {
            if (seq1.get(i) != seq2.get(i)) {
                return false;
            }
        }

        return true;
    }

    public void traverse(TreeNode node, ArrayList<Integer> list) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                list.add(node.val);
            }
            else {
                traverse(node.left, list);
                traverse(node.right, list);
            }
        }
    }
}