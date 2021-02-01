/*
 *  Unfortunately, this solution fails to solve at like test case 52/56 due to timing out.
 *  Timing on this problem is so strict even time complexity n2logn fails (needs to be nlogn
 *  but I don't want to learn fenwick trees)
*/

#include <stddef.h>

class Day12 {
public:
    struct ListNode {
        int val;
        ListNode *next;
        ListNode() : val(0), next(nullptr) {}
        ListNode(int x) : val(x), next(nullptr) {}
        ListNode(int x, ListNode *next) : val(x), next(next) {}
    };

    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int sum = 0;
        int digit = 0;
        int carry = 0;
        int currNum = 0;
        ListNode* newHead = NULL;
        ListNode* current = NULL;
        
        
        while (l1 != NULL && l2 != NULL) {
            sum = l1 -> val + l2 -> val + carry;
            digit = sum % 10;
            carry = sum / 10;
            
            if (newHead == NULL) {
                newHead = new ListNode(digit);
                current = newHead;
            }
            else {
                current -> next = new ListNode(digit);
                current = current -> next;
            }
            
            l1 = l1 -> next;
            l2 = l2 -> next;
        }
        
        while (l1 != NULL) {
            sum = l1 -> val + carry;
            digit = sum % 10;
            carry = sum / 10;
            
            current -> next = new ListNode(digit);
            current = current -> next;
            l1 = l1 -> next;
        }
        
        while (l2 != NULL) {
            sum = l2 -> val + carry;
            digit = sum % 10;
            carry = sum / 10;
        
            current -> next = new ListNode(digit);
            current = current -> next;
            l2 = l2 -> next;
        }
        
        if (carry != 0) {
            current -> next = new ListNode(carry);
        }
        
        return newHead;
    }
};