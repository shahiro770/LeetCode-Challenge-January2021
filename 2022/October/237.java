/**
 * Delete Node in a Linked List
 * 
 * Top 100% (0ms)
 * 
 * Shift all the nodes over by 1, making the last node null (so we have to stop at the 2nd last node)
 * Note that the constraint of never being given the tail node is why the code is so short.
 * 
 * Time Complexity: O(n)
 * */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        while (true) {
            if (node.next.next != null) {
                node.val  = node.next.val;
            }
            else {
                node.val = node.next.val;
                node.next = null; 
                break;
            }
            node = node.next;
        }
        
    }
}