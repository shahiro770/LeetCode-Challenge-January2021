/*
 * Remove Nth Node From End of List
 * 
 * September 2022
 * Top 75% (1ms)
 * 
 * Jump ahead by n nodes first and then run to the end of the list with both your lookahead
 * and current node. The current node's next (which is n nodes behind the lookahead) will be the 
 * node to remove.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode skip = head;
        
        for (int i = 0; i < n; i++) {
            skip = skip.next;
            // since the problem's constraints guarantee  1 <= n <= length of the list
            // if the skip reaches the end of the list, that means the head node is the
            // nth node from the end
            if (skip == null) {
                return head.next;
            }
        }
       
        // continue jumping with skip until we reach the end
        while (skip.next != null) {
            curr = curr.next;
            skip = skip.next;
        }
        
        curr.next = curr.next.next;
        return head;
    }
}

/*
1, 2, Null
C
      N
2  

[1,2,3,4,5]
2
*/