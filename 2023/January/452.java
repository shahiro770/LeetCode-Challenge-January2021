/*
 * Minimum Number of Arrows to Burst Balloons
 * 
 * Top 84% (72ms)
 * 
 * Sort the ballons by starting index. As soon as the smallest right boundary of balloons you've seen gets passed
 * by the current balloons left, pop them all and repeat the process.
 * 
 * This solution time can be halved if you binary search for the first balloon that will pass the min right,
 * as well as the min right in balloons that are in your window, but thats too much work
 * 
 * Time Complexity: O(n)
 *
 * */

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] > b[0]) {
                return 1;
            }
            else {
                if (a[0] == b[0] && a[1] > b[1]) {
                    return 1;
                }
                return -1;
            }
        });

        int currBalloon = 0;
        int arrows = 1;

        int pos = 1;
        int minRight = points[currBalloon][1];

        while (pos < points.length) {
            if (points[pos][0] > minRight) {
                currBalloon = pos;
                minRight = points[currBalloon][1];
                arrows++;
            }
            minRight = Math.min(minRight, points[pos][1]);
            pos++;
        }

        return arrows;
    }
}