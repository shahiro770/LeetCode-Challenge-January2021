/**
 * N-ary Tree Level Order Traversal
 * 
 * September 2022
 * Top 96% (2ms)  
 * 
 * Pseudo-BFS. Cute optimization note in using an enhanced for loop instead of using a list's
 * .get() method (saved me 4 ms).
 * 
 * Time complexity: O(n) since we compute something on each node twice 
 * (once to add to the queue, a second time when we visit it again to get its children).
 * 
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> listSol = new ArrayList<List<Integer>>();
        
        Queue<Node> nodeQueue = new LinkedList<Node>();
        if (root != null) {
            nodeQueue.add(root);      
        }
        
        while (nodeQueue.size() > 0) {
            ArrayList<Integer> levelVals = new ArrayList<Integer>();
            // lock in the size of the queue at a given level so we know when to stop adding nodes to the current level
            int levelSize = nodeQueue.size();   
            for (int i = 0; i < levelSize; i++) {
                Node curr = nodeQueue.remove();
                levelVals.add(curr.val);
                for (Node n : curr.children) {
                    nodeQueue.add(n);
                }
            }
            listSol.add(levelVals);
        }
        
        return listSol;
        
    }
}