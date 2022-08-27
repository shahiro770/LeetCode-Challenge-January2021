#include <stddef.h>

class Day5 {
public:
    struct ListNode {
        int val;
        ListNode *next;
        ListNode() : val(0), next(nullptr) {}
        ListNode(int x) : val(x), next(nullptr) {}
        ListNode(int x, ListNode *next) : val(x), next(next) {}
    };
    ListNode* deleteDuplicates(ListNode* head) {
        if (head == NULL || head -> next == NULL) {
            return head;
        }
        else {
            if (head -> val == head -> next -> val) {
                if (head -> next -> next != NULL) {
                    if (head -> val == head -> next -> next -> val) {
                        head = deleteDuplicates(head -> next); 
                    }
                    else {
                        head = deleteDuplicates(head -> next -> next); 
                    }
                }
                else {
                    return NULL;
                }
            }
            else {
                head -> next = deleteDuplicates(head -> next);
            }
            return head;
        }
        
        return head;
    }
};