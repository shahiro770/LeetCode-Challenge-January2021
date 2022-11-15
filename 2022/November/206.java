/*
 * Reverse Linked List
 * 
 * Top 100% (0ms)
 * 
 * Excluding the original head (who will get its next set to null to avoid a cycle)
 * the logic is as follows:
 * 1) Take the current node, its next node, and its nextnext node
 * 2) Make next -> current
 * 3) Set the current to next, next to nextnext, and nextnext to nextnextnext
 * 4) Go to 1) until we reach null
 * 
 * Highkey not the easiest leetcode easy.
 * 
 * Time complexity: O(n)
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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode temp;
        prev.next = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
}

/*
head = (2, 1)
2 = (3, 2)
3 = (4, 3)
4 = (5 , 4)
5 = (null , 5)
1 -> 2 -> 3 -> 4 -> 5

*/