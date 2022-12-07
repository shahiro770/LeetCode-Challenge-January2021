/**
 * Odd Even Linked List
 * 
 * Top 100% (0ms)
 * 
 * Due to teh restriction, we can just create new nodes as we iterate through the list.
 * You need to change the next pointers as you iterate which is slightly more difficult.
 * 
 * By storing the current pointer node as temp, and then moving the current node up one,
 * we can manipulate its next pointer while maintaining the rest of the linked list. This way
 * the question can be broken into 3 steps:
 * 1) If we're currently on an odd node, append it to the odd "section" of the linked list
 * 2) If we're currently on an even node, append it to the even "section" of the linked list
 * 3) Once our current pointer node reaches the end, append the head of the even section
 * to the tail of the odd section
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        else if (head.next == null || head.next.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode oddHead = odd;
        ListNode even = head.next;
        ListNode evenHead = even;
        ListNode curr = head.next.next;
        ListNode temp = curr;
        boolean toggle = true;

        while (curr != null) {
            temp = curr;
            curr = curr.next;
            if (toggle == true) {
                odd.next = temp;
                odd = odd.next;
                toggle = false;
            }
            else {
                even.next = temp;
                even = even.next;
                toggle = true;
            }
        }
        /*
            Case 1: Even's tail will be pointing to the last node in odd if the linked list is odd length
            Case 2: Odd's tail will be pointing to the last node in even if the linked list is even length
            Case 2 is resolved by appending even to odd, but case 1 needs us to set even's next to null
            to avoid a cycle.
        */
        even.next = null;   
        odd.next = evenHead;
        return oddHead;
    }
}

/*
1 -> 2 -> 3 -> 4 -> 5
                    O
                E
                    C

1 -> 2 -> 3 -> 4 -> 5 -> 6
                    O
                         E
                         C
*/