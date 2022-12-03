/**
 * Merge k Sorted Lists
 * 
 * Top 87% (4ms)
 * 
 * Using a priority queue is the easy solution. The slightly less easy one
 * is to make a divide and conquer style mergesort between 2 lists, and then call that k -1 times
 * until you've merged all lists.
 * 
 * Time Complexity: O(nlgn) beacause priority queue will be doing a lgn heapify
 * n times where n is the total number of nodes
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode curr = null;
        ListNode polled = null;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(new NodeComparator());

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                q.offer(lists[i]);
            }
        }

        while (q.size() > 0) {
            polled = q.poll();

            if (head == null) {
                curr = polled;
                head = curr;
            }
            else {
                curr.next = polled;
                curr = curr.next;
            }

            polled = polled.next;
            if (polled != null) {
                q.offer(polled);
            }
        }

        return head;
    }

    private class NodeComparator implements Comparator<ListNode> {

        public int compare (ListNode a, ListNode b) {
            return a.val - b.val;
        }
    }
}