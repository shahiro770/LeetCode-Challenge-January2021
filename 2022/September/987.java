/**
 * Vertical Order Traversal of a Binary Tree
 * 
 * September 2022
 * Top 43% (6ms)  
 * 
 * Annoying to think about leetcode hard. The vertical order traversal wants you to treat a binary tree
 * like a 2d plane with coordinates. Rows start at 0 and increase by 1 as you descend and columns go
 * -1/+1 when moving to the left/right child respectively.
 * 
 * The catch is if two nodes have the same coordinates, you need to sort them in ascending order.
 * To make it slightly more annoying the format you return in is a 2d list, not a 3d list. 
 * You need to merge all lists on the same row in a given column in descending order of rows.
 * 
 * My solution is to use a treemap containing a treemap of lists. There's definitely an inefficiency in there
 * but 6ms doesn't make me much slower than the top solution. I'm too lazy to rewrite this and experiment
 * with other data structures (sets, priority queues, etc.).
 * The first treemap indexes by column and the second indexes by row. "DFS" down the tree putting everything
 * where it needs to be and then sort and merge before providing the answer.
 * 
 * Time complexity: O(n^2) I think. 
 * 
 * 
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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> sol = new TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>>();
        List<List<Integer>> listSol = new ArrayList<List<Integer>>();
        
        traverse(root, 0, 0, sol);
        
        for (Map.Entry<Integer, TreeMap<Integer, ArrayList<Integer>>> col : sol.entrySet()) {
            ArrayList<Integer> toAdd = new ArrayList<Integer>();
            
            for (Map.Entry<Integer, ArrayList<Integer>> row: col.getValue().entrySet()) {
                ArrayList<Integer> listAtCoords = row.getValue();
                Collections.sort(listAtCoords);
                for (int i = 0; i < listAtCoords.size(); i++) {
                    toAdd.add(listAtCoords.get(i));
                }
            }
            
            listSol.add(toAdd);
        }
        
        return listSol;
    }
    
    public void traverse(TreeNode node, int row, int col, TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> sol) {
        if (node != null) {
            TreeMap<Integer, ArrayList<Integer>> colIndex = sol.getOrDefault(col, new TreeMap<Integer, ArrayList<Integer>>());
            ArrayList<Integer> rowIndex = colIndex.getOrDefault(row, new ArrayList<Integer>());
            rowIndex.add(node.val);
            colIndex.put(row, rowIndex);
            sol.put(col, colIndex);
            traverse(node.left, row + 1, col - 1, sol);
            traverse(node.right, row + 1, col + 1, sol);
        }
    }
}

/*
[1,2,3,4,5,6,7]
[1,2,3,4,6,5,7]
[3,1,4,0,2,2]
*/