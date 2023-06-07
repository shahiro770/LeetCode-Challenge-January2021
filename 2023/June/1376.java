/*
 * Detonate the Maximum Bombs
 * 
 * Top 45% (106 ms) (probably can do this without creating treenode classes)
 * 
 * The catch for this bfs/dfs is that informing can be done in parallel. For example
 * 1) Boss tells employees 1 and 2 in 1 minute the news
 * 2) Employees 1 and 2 take 2 and 3 minutes respectively to tell their subordinates
 * 3) It takes 1 minute to tell 1,2, but the bottleneck for the second round is employee 2 
 * taking 3 minutes to tell his subordinates
 * 4) The total time for this interaction is 4 minutes as employee 1 will be done while 2 finishes
 * 
 * To account for this, simply add the superior's inform time to the subordinate's informTime.
 * The answer will update to always be the maximum inform time seen.
 * 
 * Time Complexity: O(n) 
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