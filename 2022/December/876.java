/**
 * Middle of the Linked List
 * 
 * Top 100% (0ms)
 * 
 * If you have a fast pointer that moves twice the speed of the slow, when it reaches the end,
 * slow will have traveled half of its distance. In other words, slow will have reached the middle
 * of the list. Keep a  node counter of how many nodes the fast has travelled and you will know
 * if your list is even or odd length.
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
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int nodeCount = 0;

        while (true) {
            // note that we need to terminate before moving slow if we reach the end
            // otherwise slow moves up past the middle
            if (fast.next == null) {    
                nodeCount += 1;
                break;
            }
            else {
                fast = fast.next.next;
                nodeCount += 2;
                if (fast == null) {
                    break;
                }
            }
            slow = slow.next;
        }

        if (nodeCount % 2 == 1) {
            return slow;
        }
        else {
            return slow.next;
        }
    } 
}