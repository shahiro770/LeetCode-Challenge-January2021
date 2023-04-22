/**
 * Construct Quad Tre
 * 
 * Top 100% (0ms)
 * 
 * Not my original solution cause my solution was garbage.
 * 
 * It's divide and conquer but with an annoying check of needing to see if a quadrant is all matching.
 * 
 * Time Complexity: O(n^2 * lgn)as you will need to check every square in the nxn grid, though a square won't be
 * checked more than lgn times. This is actually a subotpimal solution as you can have the quadrants check themselves
 * and tell you if they're leaves or not first, skipping the iteration at the start. However, this still produced
 * a 0ms solution, so the testcases here suck.
 * 
 * */

/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/


class Solution {
    public Node construct(int[][] grid) {
         int n = grid.length;
         return buildQuadTree(grid, 0, 0, n - 1, n - 1);
     }
     
     private Node buildQuadTree(int[][] grid, int left, int top, int right, int bottom) {
         // check if the sub-grid consists of the same value
         boolean isLeaf = true;
         int val = grid[top][left];
         for (int i = top; i <= bottom; i++) {
             for (int j = left; j <= right; j++) {
                 if (grid[i][j] != val) {
                     isLeaf = false;
                     break;
                 }
             }
             if (!isLeaf) {
                 break;
             }
         }
         // create a leaf node is true
         if (isLeaf == true) {
             if (val == 1) {
                 return new Node(true, true, null, null, null, null);
             }
             return new Node(false, true, null, null, null, null);
         }
         // divide into four sub-grids otherwise
         int midRow = (top + bottom) / 2;
         int midCol = (left + right) / 2;
         Node topLeft = buildQuadTree(grid, left, top, midCol, midRow);
         Node topRight = buildQuadTree(grid, midCol + 1, top, right, midRow);
         Node bottomLeft = buildQuadTree(grid, left, midRow + 1, midCol, bottom);
         Node bottomRight = buildQuadTree(grid, midCol + 1, midRow + 1, right, bottom);
         // create a non-leaf node with the four children
         return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
     }
 }