/**
 * Delete the Middle Node of a Linked List
 * 
 * Top 95% (4ms)
 * 
 * Have a fast pointer that moves twice the speed as the slow.
 * If we say the fast is moving at speed n, and the slow is moving at speed n/2,
 * the slow pointer will cover half the distance the fast pointer does at the same time.
 * This is a complicated way to say it will reach the middle by the time the fast reaches the end.
 * 
 * Time Complexity: O(n)
 * */

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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode beforeSlow = head;
        ListNode slow = head;
        while (true) {
            /*
             * If the list is odd length, the fast pointer will arrive at the last node
             * while if it is even, it will jump to null from the 2nd last node.
             * In the odd case, the slow pointer will be in the perfect spot to remove the middle 
             * after the fast pointer jumps.
             * In the even case, we need to move the slow pointer up once before making the deletion
             * to sync things up properly
             */
            if (fast.next != null) {    // odd case
                fast = fast.next.next;
                 if (slow == beforeSlow) {
                    slow = slow.next;
                }
                else {
                    slow = slow.next;
                    beforeSlow = beforeSlow.next;
                }
                if (fast == null) {
                    break;
                }
            }
            else {                      // even case
                fast = fast.next;
                if (fast == null) {
                    break;
                }
                 if (slow == beforeSlow) {
                    slow = slow.next;
                }
                else {
                    slow = slow.next;
                    beforeSlow = beforeSlow.next;
                }
            }
        }
        beforeSlow.next = slow.next;

        return head;
    }
}

/*
1,3,4,7,1,2,6
      S
            F
1,2,3,4
  S
        F

*/