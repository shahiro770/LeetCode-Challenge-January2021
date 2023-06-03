/*
 * Detonate the Maximum Bombs
 * 
 * Top 37% (159 ms) (its slow cause im too lazy to not flood the call stack)
 * 
 * The tricky part here is figuring out if a bomb can detonate another bomb.
 * To do this, use the distance between two points formula for bombs b1 and b2
 * (with b1 detonating)
 *      1) ((x2 - x1)^2 + (y2 - y1)^2)^(1/2) = d
 *      2) (x2 - x1)^2 + (y2 - y1)^2 = d^2
 *      Now in our case, as long as the distance is less than that explosion radius,
 *      we can consider b2 in the radius of b1. So our formula becomes
 *      3) (x2 - x1)^2 + (y2 - y1)^2 <= r1^2
 * 
 * With this, we can construct a graph (b1 and b2 share an edge if b2 is in the radius
 * of b1). From here its your choice of dfs or bfs to find the largest connected component.
 * 
 * Time Complexity: O(n + n^2) if every bomb can reach every other bomb
 */

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        TreeNode root = new TreeNode(headID, informTime[headID]);
        HashMap<Integer, TreeNode> empMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            empMap.put(i, new TreeNode(i, informTime[i]));
        }

        for (int i = 0; i < manager.length; i++) {
            if (i != headID) {
                empMap.get(manager[i]).addSub(empMap.get(i));
            }
        }

        int totalTime = 0;
        Deque<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(empMap.get(headID));
        while (queue.size() > 0) {
            TreeNode curr = queue.poll();

            totalTime = Math.max(curr.informTime, totalTime);
            for (int i = 0; i < curr.subs.size(); i++) {
                curr.subs.get(i).informTime += curr.informTime;
                queue.offer(curr.subs.get(i));
            }
        }

        return totalTime;
    }

    private class TreeNode {
        int informTime = 0;
        int index;
        ArrayList<TreeNode> subs;

        private TreeNode(int index, int informTime) {
            subs = new ArrayList<>();
            this.index = index;
            this.informTime = informTime;
        }

        private void addSub(TreeNode sub) {
            subs.add(sub);
        }
    }
}