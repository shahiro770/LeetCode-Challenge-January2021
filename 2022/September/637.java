/**
 * Average of Levels in Binary Tree
 * 
 * September 2022
 * Top 78% (3ms)
 * 
 * Faster way to do it with a queue so you don't need to do a loop of the levels
 * or waste time with arraylists resizing (not that this question has large enough inputs to do that)
 * (i.e. save log(n - 2) - 1 operations)
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
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Long> sums = new ArrayList<Long>();
        ArrayList<Integer> counts = new ArrayList<Integer>();
        List<Double> sol = new ArrayList<Double>();
        
        sumAndCount(root, 0, sums, counts);
        
        for (int i = 0; i < sums.size(); i++) {
            sol.add((double)sums.get(i) / (double)counts.get(i));
        }
        
        return sol;
    }
    
    public void sumAndCount(TreeNode node, int pos, ArrayList<Long> sums, ArrayList<Integer> counts) {
        if (node != null) {
            if (pos == sums.size()) {
                sums.add((long)node.val);
                counts.add(1);
            }
            else {
                sums.set(pos, sums.get(pos) + node.val);
                counts.set(pos, counts.get(pos) + 1);
            }
            sumAndCount(node.left, pos + 1, sums, counts);
            sumAndCount(node.right, pos + 1, sums, counts);
        }
    }
}