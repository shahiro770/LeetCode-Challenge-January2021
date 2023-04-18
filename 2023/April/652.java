/*
 * Find Duplicate Subtrees
 *
 * Top 96% (8ms)
 * 
 * Use strings to keep track of subtree, storing them in a map. If we ever see a subtree already exists,
 * put it in a set.
 * 
 * Time Complexity: O(n) n nodes, containsKey is O(1) apparently
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
    HashMap<String, TreeNode> subTrees;
    Set<TreeNode> sol;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        subTrees = new HashMap<>();
        sol = new HashSet<TreeNode>();
        traverse(root);

        return new ArrayList<TreeNode>(sol);
    }

    public String traverse(TreeNode node) {
        if (node != null) {
            StringBuilder sb = new StringBuilder();

                if (node.left != null) {
                    sb.append(traverse(node.left));
                    sb.append("L");
                }
                if (node.right != null) {
                    sb.append(traverse(node.right));
                    sb.append("R");
                    
                }
                sb.append(node.val);

            String subtree = sb.toString();

            if (subTrees.containsKey(subtree)) {
                sol.add(subTrees.get(subtree));
            }
            else {
                subTrees.put(subtree, node);
            }

            return subtree;
        }

        return null;
    }
}