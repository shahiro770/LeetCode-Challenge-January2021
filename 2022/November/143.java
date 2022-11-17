/*
 * Reorder List
 *
 *  Top 69% (3ms)
 * 
 * All the top solutions divide the list in half. The difference between mine and the 1ms/2ms sols
 * are that those solutions take the second half and reverse it, whereas I use a stack/queue.
 * If you really care to reverse a list, look at 206.
 * 
 * Time complexity: O(n)
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
    public void reorderList(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<ListNode>();
        Deque<ListNode> queue = new ArrayDeque<ListNode>();
        boolean toggle = false;
        ListNode curr = head;

        int length = 0;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        curr = head;
        for (int i = 0; i < length / 2; i++) {
            queue.offer(curr);
            curr = curr.next;
        }
        if (length % 2 == 1) {
            queue.offer(curr);
            curr = curr.next;
        }
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        curr = queue.poll();
        toggle = false;  
        for (int i = 1; i < length; i++) {
            if (toggle == true) {
                curr.next = queue.poll();
                toggle = false;
            }
            else {
                curr.next = stack.pop();
                toggle = true;
            }
            curr = curr.next;
        }
        
        curr.next = null;
    }
}