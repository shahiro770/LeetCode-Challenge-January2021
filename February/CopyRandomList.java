/**
 * Feb 2021 Day 10
 * 
 * Top 100% woooooo.
 * Since its a deep copy this problem gets a little annoying, as well as random null checks
 *      1) Create copy nodes, interweave them into the og list (e.g. 1 -> 1' -> 2 -> 2' -> ... -> null)
 *      2) Travelling to each og node, set its copy node's random pointer to the og node's random's next
 *          This will give you the random equivalent
 *      3) Unweave the lists to preserve the og and finalize the copy
 * O(n) cause we got 3 loops on linked lists of size n
 */

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        Node newHead = null;
        Node newNext = null;
        while (curr != null) {
            newNext = new Node(curr.val);
            newNext.next = curr.next;
            newNext.random = null;
            if (newHead == null) {
                newHead = newNext;
            }
            curr.next = newNext;
            curr = newNext.next;
            
        } 
        
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;    
            }
            curr = curr.next.next;
        }
        
        curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = curr.next.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            curr = curr.next;
        }
        
        return newHead;
    }
}