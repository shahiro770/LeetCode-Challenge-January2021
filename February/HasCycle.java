
/**
 * Feb 2021 Day 3
 * Dumb Solution: Make either a hashtable or array, mark nodes as your pointer iterates, visitng a marked node returns true
 * Smart Solution: Make use of the floyd tortoise hare cycle detecting algorithm
 *      Slow tortoise pointer moves one node at a time
 *      Fast hare pointer moves two nodes at a time
 *      If both pointers get trapped in a cycle, they will eventually intersect at O(n) time
 *          Why its O(n) before it intersects? Something something modular math
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