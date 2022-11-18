/*
 * Rectangle Area
 * 
 * Top 84% (3ms)
 * 
 * You need to draw this one out. The basic idea of areaA - areaB - overlap makes sense, but
 * how do you determine overlap?
 * There's 3 cases, and we'll look at the bottom edge of the xCoords to visualize:
 * 
 * Case 1: Partial overlap
 * 
 *  a1 ----------- a2
 *          b1 ------------ b2
 * 
 * The overlapping square area diff is equal to a2 - b1.
 * 
 * Case 2: Complete overlap
 * 
 *  a1 ----------- a2
 *       b1 -- b2
 * 
 * The overlapping square area is b2 - b1
 * 
 *  Case 3: No overlap
 * 
 * a1 ----------- a2
 *                        b1 ------------ b2
 * 
 * There is no overlap, but if our math computed a2 - b1 like in case 1, 
 * we'd get a negative value.
 * 
 * Seeing all the combinations with if a1 < b1 or if b1 < a1, with similar pairings
 * it may seem like a lot of edge cases to handle, but in reality the logic can be simplified. 
 * Notice that the larger of the starting coordinates is always subtracted from the smaller of the ending coordinates.
 * Accounting for negative meaning no overlap, we can solve the problem very easily
 * (minus handling the rectangle area calculation which I don't know if java has a built
 * in function for).
 * 
 * Time Complexity: O(1)
 */

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaA = calculateArea(ax1, ay1, ax2, ay2);
        int areaB = calculateArea(bx1, by1, bx2, by2);

        int xOverlap = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int yOverlap = Math.min(ay2, by2) - Math.max(ay1, by1);
        if (xOverlap < 0 || yOverlap < 0) {
            return areaA + areaB;
        }
        return areaA + areaB - (xOverlap * yOverlap);
    }

    public int calculateArea(int x1, int y1, int x2, int y2) {
        int xDiff = 0;
        int yDiff = 0;;
        if (x2 < 0 && x1 > 0) {
            xDiff = x2 * -1 + x1;
        }
        else if (x2 > 0 && x1 < 0) {
            xDiff = x2 + x1 * -1;
        }
        else {
            xDiff = Math.abs(x2 - x1);
        }
        if (y2 < 0 && y1 > 0) {
            yDiff = y2 * -1 + y1;
        }
        else if (y2 > 0 && y1 < 0) {
            yDiff = y2 + y1 * -1;
        }
        else {
            yDiff = Math.abs(y2 - y1);
        }

        return xDiff * yDiff;
    }
}