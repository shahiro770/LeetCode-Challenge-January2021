/**
 * Top K Frequent Elements 
 *
 * October 2022
 * Top 98% (5ms)  
 * 
 * Time complexity: O(nlgn) to maintain heap property
 * */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new NodeComparator());

        for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
            pq.add(new Node(e.getKey(), e.getValue()));   
        }

        int[] sol = new int[k];
        for (int i = 0; i < sol.length; i++) {
            sol[i] = pq.poll().val;
        }
        return sol;
    }

    private class Node  {
        int val;
        int count;

        private Node(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    private class NodeComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return b.count - a.count;
        }
    }
}