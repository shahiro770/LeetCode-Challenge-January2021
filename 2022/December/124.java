/**
 * Binary Tree Maximum Path Sum
 * 
 * Top 99% (1ms)
 * 
 * By the definition of a path, we can't run through the same node twice. This means
 * there are only two ways to path through a binary tree from a given node. 
 * 1) A run through (leftChild/subtree -> parent -> rightChild/subtree)
 * 2) A split (Choose only one of (parent -> leftChild, parent -> rightChild))
 * Suppose this was our tree
 * 
 *          A
 *   B              C
 *              D       E
 * 
 * If the starting node was A, we can consider 1) or 2)
 * If the starting node was B,D, or E, we can only consider 2) since they have no children
 * If the starting node was C, we can consider 1) or 2)
 *      Notice how if we choose to go up the tree (C -> A -> ...) we wouldn't be able to choose D or E
 *          In other words that upward path need only be considered during a runthrough from A
 * 
 * Since for case 1) to be computed requires us know the largest case 2) for any given node,
 * recursively going down the tree and computing the values back up will allow us to efficiently get
 * the maximum path sum, visiting every node only once. 
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
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode node) {
        traverse(node);

        return res;
    }

    public int traverse(TreeNode node) {
        if (node != null) {
            int left = traverse(node.left);
            int right = traverse(node.right);

            /* 
                Case 1) The path sum if we were to instead start from the bottom of the left subtree, 
                run through the current node, and descend to the bottom of the right subtree (taking max paths 
                for both subtrees)
            */
            int runThrough = left + node.val + right;  
            /*
                Case 2) The path sum from the current node if it were the start, meaning
                we can only take one of the left or right paths.

                Note that it is possible for negative values in this tree, meaning in cases like
                     3
                -1       -2
                Taking neither would give us the max path, hence we want to account for that as well
            */ 
            int maxNoRunThrough = Math.max(node.val + Math.max(left, right), node.val);
            res = Math.max(Math.max(runThrough, res), maxNoRunThrough);
            
            /*
            Return the maxNoRunThrough to the parent node as when they go to test case 1),
            they can only use the case 2) results from this node by definition of a path
            */
            return maxNoRunThrough;
        }

        return 0;
    }
}