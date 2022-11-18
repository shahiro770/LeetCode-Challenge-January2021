/*
 * Add Two Numbers
 * 
 * Top 99% (2ms)
 * 
 * At first glance you might think to just create the numbers from the linked lists,
 * add them, and then put them back into a linked list. This would work if the numbers weren't 
 * up to 100 digits long.
 * 
 * Its a little lengthy to write out, but the simple logic is to just compute 
 * the single digit math and then move to the next digit with the carryover. 
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        int carry = 0; 
        
        ListNode sol = new ListNode(0);
        ListNode solHead = sol;

        // start by adding digits for as long as we can
        while (curr1 != null && curr2 != null) {
            sol.val = curr1.val + curr2.val + carry;
            carry = 0;
            if (sol.val >= 10) {
                carry = 1;
                sol.val -= 10;
            }
            if (curr1.next != null || curr2.next != null || carry == 1) {
                sol.next = new ListNode(0);
            }
            sol = sol.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        // if the first number is longer than the second
        while (curr1 != null) {
            sol.val = curr1.val + carry;
            carry = 0;
            if (sol.val >= 10) {
                carry = 1;
                sol.val -= 10;
            }
            if (curr1.next != null || carry == 1) {
                sol.next = new ListNode(0);
            }
            
            sol = sol.next;
            curr1 = curr1.next;
        }
        // if the second number is longer than the first
        while (curr2 != null) {
            sol.val = curr2.val + carry;
            carry = 0;
            if (sol.val >= 10) {
                carry = 1;
                sol.val -= 10;
            }
            if (curr2.next != null || carry == 1) {
                sol.next = new ListNode(0);
            }
            sol = sol.next;
            curr2 = curr2.next;
        }
        // in the event there's still one digit of carryover, it will be the front
        if (carry == 1) {
            sol.val = 1;
        }

        return solHead;
    }
}