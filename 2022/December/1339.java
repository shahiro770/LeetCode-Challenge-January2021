/*
 * Maximum Difference Between Node and Ancestor
 * 
 * Top 98% (9ms)
 * 
 * Traverse through the whole tree to get the sum of the tree.
 * Then traverse it again comparing all possible products between parent and child.
 * 
 * You can't be greedy as it is not a BST so there's no telling where you'll see
 * the optimal split (which will be whatever parent/child split is the closest to half
 * the tree's sum)
 * 
 * Time Complexity: O(n)
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
class Solution {
    int totalSum;
    long maxProduct = 0;

    public int maxProduct(TreeNode root) {
        totalSum = traverseSum(root);
        traverseProduct(root);

        return (int)(maxProduct % (Math.pow(10, 9) + 7));
    }

    public int traverseSum(TreeNode curr) {
        if (curr != null) {
            int sum = curr.val + traverseSum(curr.left) + traverseSum(curr.right);

            return sum;
        }

        return 0;
    }

    public int traverseProduct(TreeNode curr) {
        if (curr != null) {
            int leftSum = traverseProduct(curr.left);
            int rightSum = traverseProduct(curr.right);
            int currentSum = leftSum + curr.val + rightSum;
            long currentProduct = (long)currentSum * (totalSum - currentSum);

             if (currentProduct > maxProduct) {
                maxProduct = currentProduct;
            }
            
            return currentSum;
        }
        return 0;
    } 
}

/*
    Suppose node knows sum of itself and all of its descendants
    [1,2,3,4,5,6]

                        1 (21)
            2(11)                  3 (9)
      4(4)         5(5)       6(6)
      
    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20

    Prod
    1 * 20 = 20
    2 * 19 = 38
    3 * 18 = 54
    4 * 17 = 68
    10 * 11 = 110
*/