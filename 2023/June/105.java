/*
 * Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Top 98% (2ms)
 * 
 * In order = left to right (left, root, right)
 * Pre order = top to bottom (root, left, right)
 * Post order = bottom to top (left, right, root)
 * 
 * Since we are given inorder and preorder, we can deduce two things from the start
 * 1) preorder's first node is the root of the full tree
 * 2) wherever preorder's first node appears in the inorder array, the nodes to its left
 * are its left subtree, and the right are its right subtree
 * 
 * Noting that all the values in this binary tree are unique we can recursively do this
 * on each subtree (always left first, then right, as thats the order in "roots" the preorder
 * tells us), to build the tree back up.
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
    HashMap<Integer, Integer> indexes;
    int[] preorder;
    int[] inorder;
    int preIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexes = new HashMap<>();
        this.preorder = preorder;
        this.inorder = inorder;
        preIndex = 0;
        

        // map the inorder values to their index in the inorder array
        for (int i = 0; i < inorder.length; i++) {
            indexes.put(inorder[i], i);
        }

        return buildTree(0, inorder.length - 1);
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) { // no elements in subtree
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex]);
        int rootIndex = indexes.get(root.val);
        preIndex++;
        
        root.left = buildTree(left, rootIndex - 1);
        root.right = buildTree(rootIndex + 1, right);
        
        return root;
    }
}