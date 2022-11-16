/*
 * Merge Two Sorted Lists
 * 
 * Top 100% (0ms)
 * 
 * Just a bunch of null checks, you can think of it as merge sort without the
 * divide and conquer.
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head;
        ListNode curr;
        if (list1 == null && list2 == null) {
            return null;
        }
        else if (list1 == null) {
            head = list2;
            list2 = list2.next;
        }
        else if (list2 == null) {
            head = list1;
            list1 = list1.next;
        }
        else if (list1.val >= list2.val) {
            head = list2;
            list2 = list2.next;
        }
        else {
            head = list1;
            list1 = list1.next;
        }
        curr = head;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                curr.next = list2;
                curr = curr.next;
                list2 = list2.next;
            }
            else {
                curr.next = list1;
                curr = curr.next;
                list1 = list1.next;
            }
        }
        if (list1 == null) {
            curr.next = list2;
        }
        else {
            curr.next = list1;
        }

        return head;
    }
}