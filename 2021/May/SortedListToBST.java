/**
 * May 2021 Day 6
 * 
 * Need to make use of a two pointer strategy:
 * The middle of the list will obviously be the root, repeating this middle process on the left and right
 * of the current middle can be used to recursively build the tree down
 * 
 * Only important nuance is to sever the list at mid points so you can easily get the midpoints 
 * 
 * Time Complexity: O(n) as we eventually divide the list down into n nodes
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode mid = mid(head);   // get the current mid
        TreeNode root = new TreeNode(mid.val);  // root at the current splitting point will be the mid
        
        if (head == mid) {  // return the root if there's only one node left in the portion of the list
            return root;
        }
        else {  // split left and right
            root.left = sortedListToBST(head);  
            root.right = sortedListToBST(mid.next);
            return root;
        }
    }
    
    /**
     * Helper function that gets the current middle node and severs the list at that point
     * Makes use of a fast and slow pointer since linked lists can't be counted
     * @param head
     * @return
     */
    public ListNode mid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        
        if (prev != null) {
            prev.next = null;
        }
        
        return slow;
    }
}

