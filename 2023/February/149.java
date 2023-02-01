/*
 * Max Points on a Line
 * 
 * Top 97% (10ms)
 * 
 * One of those questions that is easy if you remember highschool math. I forgot so I ended up copying a better solution.
 * 
 * So first, how do you get the slope between two points? a = (x1, y1), b = (x2, y2)
 *      Well the slope of the line ab is going to be (y2 - y1) / (x2 - x1)
 * Second, we want to know if another point c = (x3, y3) is on the same line as the current two points.
 *      We can do this by seeing if the lines ab and bc (or ac) share the same slope. In otherwords (for ab and bc), we are seeing
 * 
 *      y2 - y1     y3 - y1
 *      -------  =  --------
 *      x2 - x1     x3 - x1
 * 
 *      But division is messy and with floating points and rounding we might mess up our comparison. So rather than divide,
 *      let's multiply both sides by their denominators.
 * 
 *      (y2 - y1) * (x3 - x1) = (y3 - y1) * (x2 - x1)
 * 
 *      Now just solve this equation for each point between any two points and you got yourself a solution.
 *   
 * 
 * I am like half certain this turns out to be n^3, but I don't know how else you test all point combinations
 *
 * Time Complexity: O(n^3)???
 */

 class Solution {
    // This method returns the maximum number of points that lie on the same line
    // given a set of points represented by the 2D array points
    public int maxPoints(int[][] points) {
        // n is the number of points in the array
        int n = points.length;
        
        // If there are 0 or 1 points, there is at most one line that can be formed
        // (i.e., the line formed by the single point, or no line if there are no points)
        if (n <= 2) {
            return n;
        }
        // Initialize the maximum number of points on a line to 2, since there must be at least 2 points to form a line
        int ans = 2;
        
        // Iterate through all pairs of points
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++) {
                // temp is the number of points on the line formed by point i and point j
                int temp = 2;
                // Check if any other points are on the same line as point i and point j
                for(int k = j + 1; k < n; k++ ) {                   
                    // Check if point k is on the same line as point i and point j
                    // This is done by checking if the slope between point i and point k is equal to the slope between point i and point j
                    int m1 = (points[j][1] - points[i][1]) * (points[k][0] - points[i][0]);
                    int m2 = (points[k][1] - points[i][1]) * (points[j][0] - points[i][0]);
                    if (m1 == m2) {
                        // If the slopes are equal, point k is on the same line as point i and point j
                        temp++;
                    }
                }
                // Update the maximum number of points on a line if necessary
                if(temp > ans) {
                    ans = temp;
                }
            }
        }   
        // Return the maximum number of points on a line
        return ans;
    }
}