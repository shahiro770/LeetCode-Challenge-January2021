/**
 * May 2021 Day 14
 * 
 * Top 100% for time and top 57% for space (whatever)
 * 
 * You traverse along the left children, adding them to the linked list, then right 
 * 
 * Time complexity: O(n)
 */


class Solution {
    TreeNode rightMost = null;
    
    public void flatten(TreeNode root) {
        if (root != null) {
            rightMost = root;
            TreeNode oldLeft = root.left;
            TreeNode oldRight = root.right;
            root.left = null;
        
            if (oldLeft != null) {
                rightMost.right = oldLeft;
                flatten(oldLeft);
            } 
            if (oldRight != null) {
                rightMost.right = oldRight;
                flatten(root.right);
            }
        }
    }
}