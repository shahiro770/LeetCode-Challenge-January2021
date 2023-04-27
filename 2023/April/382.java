/*
 * Linked List Random Node
 *
 * Top 19% (16ms)
 * 
 * This time might look alarming, but the very easy solution of counting the nodes/putting them
 * in an array or iterating to a random index between 0 and listLength doesn't match the follow
 * up questions, which put a memory restriction. The fastest solution is also only 9ms, 7ms to use
 * double the space is barely a tradeoff.
 * 
 * The below solution uses resevoir sampling, which basically says
 *  0) Given a sample S and resevoir R
 *  1) For every element in  S, we put it in R, which is the pool of numbers we want as our random sample
 *      This pool is of a fixed size we decide; for this question we only want one number so it is size 1
 *  2) Then for each element left in S (after we've filled the pool), we decide if we want that number in the pool
 *      If we do, it overwrites an existing number in the pool
 *         Determine this via a random number generation method, giving all numbers a uniform probability to replace
 *         This process continues until we've scanned everything in S
 * 
 * Since our resevoir size is 1, the application is far simpler, kinda devolves to just bumping out
 * the number with the last seen number, giving us the O(1) space.
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
    ListNode head;

    public Solution(ListNode head) {
       this.head = head;
    }
    
    public int getRandom() {
        int resevoirSize = 1;
        int randomVal = -1; // this will get overriden on the first check as resevoir size starts at 1
        ListNode curr = head;
        while (curr != null) {
            
            if (Math.random() < 1.0 / resevoirSize) {
                randomVal = curr.val;
            }
            curr = curr.next;
            resevoirSize += 1;
        }

        return randomVal;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */