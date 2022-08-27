/**
 * Palindrome Linked List
 * 
 * August 2022
 * Top 56% (8ms)
 * 
 * You can optimize it more by reversing the linked list but I didn't want to 
 * mess with the original structure.
 */ 

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode tail = head;
        int listLength = 0;
        while (tail != null) {
            tail = tail.next;
            listLength++;
        }
        int[] vals = new int[listLength];
        
        tail = head;
        for (int i = 0; i < listLength; i++) {
            vals[i] = tail.val;
            tail = tail.next;
        }
        for (int i = 0; i < vals.length / 2; i++) {
            if (vals[i] != vals[vals.length - i - 1]) {
                return false;
            }
        }
        
        return true;
    }
}