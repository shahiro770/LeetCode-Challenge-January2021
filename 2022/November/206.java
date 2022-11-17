/*
 * Reverse Linked List
 * 
 * Top 100% (0ms)
 * 
 * Excluding the original head (who will get its next set to null to avoid a cycle)
 * the logic is as follows:
 * 1) Take the current node, its next node, and its nextnext node
 * 2) Make next -> current
 * 3) Set the current to next, next to nextnext, and nextnext to nextnextnext
 * 4) Go to 1) until we reach null
 * 
 * Highkey not the easiest leetcode easy.
 * 
 * Time complexity: O(n)
 * */

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
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right =root.right;
        int leftDepth = 1;
        int rightDepth = 1;

        while (left != null) {
            left = left.left;
            leftDepth++;
        }
        while (right != null) {
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth) {
            return (int)Math.pow(2, rightDepth) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

/*
                            1
                2                      3
        4           5           6           7
    8       9   10      11   12     13    14     15

    1R = 2^2 - 1
    2R = 2^3 - 1
    1R 1L = 2^3 - 2
    1L = 2^
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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode temp;
        prev.next = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
}

/*
head = (2, 1)
2 = (3, 2)
3 = (4, 3)
4 = (5 , 4)
5 = (null , 5)
1 -> 2 -> 3 -> 4 -> 5

*/