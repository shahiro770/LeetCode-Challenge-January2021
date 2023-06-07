/*
 * Check If It Is a Straight Line
 *
 * Top 100% (0ms)
 * 
 * Fun fact, java dividing by 0 for floats gives +/- 0.0 or
 * +/- infinities.
 * 
 * */

class Solution {
    
    public boolean checkStraightLine(int[][] coordinates) {
        // coordinates.length >= 2
        float ydiff = (coordinates[1][1] - coordinates[0][1]);
        float xdiff = (coordinates[1][0] - coordinates[0][0]);
        float slope = (ydiff/xdiff);

        for (int i = 2; i < coordinates.length; i++) {
            ydiff = (coordinates[i][1] - coordinates[i - 1][1]);
            xdiff = (coordinates[i][0] - coordinates[i - 1][0]);

            float newSlope = (ydiff/xdiff);

            if (newSlope != slope) {
                if (Double.isInfinite(newSlope) == false || Double.isInfinite(slope) == false) {
                    return false;
                }
            }
        }

        return true;
    }
}
