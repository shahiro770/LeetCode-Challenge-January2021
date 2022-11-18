/*
 * Linked List Cycle
 * 
 * Top 99% (2ms)
 * 
 * You use a slow pointer than moves at a rate of one node, and a fast pointer that moves
 * twice as fast. If there is a cycle, the fast pointer will eventually catch up to the slow pointer,
 * and then they'll be pointing to the same node. (e.g. if the distance between the pointers was
 * 10, the slow increases the gap by one while the fast decreases the gap by 2, eventually becoming 0).
 * 
 * An O(n) memory solution would be to use a hashmap and just map the nodes visited by a single pointer
 * and see if there's a match.
 * 
 * Time Complexity: O(n)
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;
        if (hare == null) {
            return false;
        }
        hare = tortoise.next;
        while (hare != null) {
            tortoise = tortoise.next;
            if (hare.next != null) {
                hare = hare.next.next;
            }
            else {
                return false;
            }
            if (tortoise == hare) {
                return true;
            }
        } 
        
        return false;
    }
}