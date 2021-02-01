/**
 * Literally top 99.59%, and top 98% in memory, slapped this question down
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
class Day29 {
    int minKey = 0;
    int maxKey = 0;
    HashMap<Integer, ArrayList<CoordNode>> intMap = new HashMap<Integer, ArrayList<CoordNode>>();
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> soln = new ArrayList<List<Integer>>();
        NodeComparator nc = new NodeComparator();
        vtHelper(root, 0, 0);
        
        for (int i = minKey; i <= maxKey; i++) {
            ArrayList<Integer> nextCol = new ArrayList<Integer>();
            ArrayList<CoordNode> coordNodes = intMap.get(i);
            Collections.sort(coordNodes, nc);
            for (int j = 0; j < coordNodes.size(); j++) {
                nextCol.add(coordNodes.get(j).val);
            }
            soln.add(nextCol);
        }
        
        return soln;
    }
    
    public void vtHelper(TreeNode curr, int x, int y) {
        if (intMap.get(x) == null) {
            intMap.put(x, new ArrayList<CoordNode>());
        }
        intMap.get(x).add(new CoordNode(x, y, curr.val));
        
        if (curr.left != null) {
            if (x - 1 < minKey) {
                minKey = x - 1;
            }
            vtHelper(curr.left, x - 1, y + 1);
        }
        if (curr.right != null) {
            if (x + 1 > maxKey) {
                maxKey = x + 1;
            }
            vtHelper(curr.right, x + 1, y + 1);
        }
    }
    
    class NodeComparator implements Comparator<CoordNode> {
        public int compare(CoordNode a, CoordNode b) {
            if (a.y == b.y) {
                return a.val - b.val;
            }
            else  {
                return a.y - b.y;
            }
        }
    }
    
    class CoordNode {
        int x;
        int y;
        int val;
        
        public CoordNode(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}