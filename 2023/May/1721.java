/*
 * Swapping Nodes in a Linked List
 *
 * Top 99% (2ms)
 * 
 * Time Complexity: O(n)
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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;
        ListNode a = null;
        int length = 0;
        while (curr != null) {
            length++;
            if (length == k) {
                a = curr;
            }
            curr = curr.next;
        }
        curr = head;
        while (length != k) {
            curr = curr.next;
            length--;
        }

        int temp = a.val;
        a.val = curr.val;
        curr.val = temp;
        return head;
    }
}