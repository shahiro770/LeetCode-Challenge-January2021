/***
 * This solution kinda sucks ngl 3ms because i'm using a map (obv this is negligible compare to 2ms 
 * solution that uses a bfs), though memory usage is heavy
 * 
 * Just add to a global variable and have your recursive calls update it.
 * 
 * O(n) time complexity
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
    Map<Integer, ArrayList<Double>> vals = new HashMap<Integer, ArrayList<Double>>();
    
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> averages = new ArrayList<Double>();  
        
        traverse(root, 0);
        
        for (Map.Entry<Integer, ArrayList<Double>> entry : vals.entrySet()) {
            double avg = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                avg += entry.getValue().get(i);
            } 
            averages.add(avg / entry.getValue().size());
        }
        
        return averages;
    }
    
    public void traverse(TreeNode n, int depth) {
        if (n != null) {
            vals.computeIfAbsent(depth, z -> new ArrayList<Double>()).add((double)n.val);
            
            traverse(n.left, depth + 1);
            traverse(n.right, depth + 1);
        }
    }
}