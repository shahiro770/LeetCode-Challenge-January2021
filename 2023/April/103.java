/*
 * Binary Tree Zigzag Level Order Traversal
 * 
 * Top 77% (1ms)
 * 
 * Keep track of the directino you need to be adding nodes to the next layer of your "read queue".
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> currentLayer = new LinkedList<TreeNode>();
        Deque<TreeNode> nextLayer = new LinkedList<TreeNode>();

        List<List<Integer>> sol = new ArrayList<List<Integer>>();

        currentLayer.offerFirst(root);
        int dir = 1; // left = 1, right = -1

        while (currentLayer.size() > 0) {
            ArrayList<Integer> currLayerVals = new ArrayList<Integer>();
            int currentLayerSize = currentLayer.size();

            for (int i = 0; i < currentLayerSize; i++) {
                TreeNode curr = currentLayer.poll();

                if (curr != null) {
                    currLayerVals.add(curr.val);
                    if (dir == 1) {
                        nextLayer.offerFirst(curr.left);
                        nextLayer.offerFirst(curr.right);
                    }
                    else {
                        nextLayer.offerFirst(curr.right);
                        nextLayer.offerFirst(curr.left);
                    }
                }
            }
            dir = dir * -1;
            if (nextLayer.size() > 0) {
                sol.add(currLayerVals);
            }
            currentLayer = nextLayer;
            nextLayer = new LinkedList<TreeNode>();
        }

        return sol;
    }
}