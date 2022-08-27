import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {   
        ListNode head = null;
        ListNode curr = null;
        ListNode polled = null;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(new NodeComparator());
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                q.add(lists[i]);
            }
        }
        
        if (q.isEmpty() == false) {
            polled = q.poll();
            head = polled;
            curr = head;
            if (polled.next != null) {
                q.add(polled.next);
            }
        }
        
        while(q.isEmpty() == false) {
            polled = q.poll();
            if (polled.next != null) {
                q.add(polled.next);
            }
            curr.next = polled;
            curr = curr.next;
        }
        
        return head;
    }
    class NodeComparator implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}