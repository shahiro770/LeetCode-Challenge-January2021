/*
 * Reverse Nodes in k-Group
 *
 * Top 100% (0ms)
 * 
 * Starting from the end is easier when using recursion since the head of the last k-group/
 * remaining group that isn't a k-group will be connected to the tail of the previous k-group.
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        while (curr != null && count < k) {
            count++;
            curr = curr.next;
        }

        if (count == k) {
            /*
             *  Case 1: Get the head of the last group of nodes less than k or null
             *  Case 2: Get the head of the next k-group as you go back up the call-stack
             */
            curr = reverseKGroup(curr, k); 
            while (count > 0) {
                /*
                 * Step 1: Store the next of the head of the k-group as it will be lost otherwise
                 * Step 2: Make the head's next point to curr (or the head of the next k-group if its the first iteration)
                 * 
                 * This is where re-using the variable names makes the logic messy even if it makes
                 * the code short.
                 * 
                 * Step 3: Set curr to the head (i.e. moving curr up one) 
                 * Step 4: Set head to the current head's old next (i.e. moving head down one)
                 * 
                 * Head will eventually point to null or to what the tail of the k-group initially pointed to (this won't be used)
                 * Curr will point to the new head
                 * Set head to curr at the end and return it as the rightful new head of the k-group
                 */
                ListNode temp = head.next;  
                head.next = curr;
                curr = head;
                head = temp;

                count--;
            }

            head = curr;
        }

        return head;
    }
}

/*
Curr = null
Head = 1

1 -> 2 -> 3

Temp = 2
1 -> null
curr = 1
head = 2

1 -> null  2 -> 3

temp = 3
2 -> 1
curr = 2
head = 3

2 -> 1 -> null  3

temp = null
3 -> 2
curr = 3
head = null
*/