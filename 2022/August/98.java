/**
 * Validate Binary Search Tree
 * Aug 2022 Day 11
 * 
 * Do an inorder traversal then see if the list is sorted.
 * Can be solved faster by just doing a DFS and passing down the low and high that 
 * the nodes need to be between as you go down the list.
 * 
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
    boolean isBalanced = true;
    
    public boolean isValidBST(TreeNode root) {  
        ArrayList<Integer> nums = inorderTraversal(root);
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) >= nums.get(i + 1)) {
                return false;
            }
        }
        
        return true;
    }
    
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        
        while (curr != null || stack.isEmpty() == false) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;    
            }
           
            curr = stack.pop();
            System.out.println(curr.val);
            list.add(curr.val);
            
            curr = curr.right;
        }
            
        return list;
    }
}