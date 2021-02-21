/**
 * Feb 2021 Day 21
 * 
 * Going from X to Y is tricky to think about since pure greed will fail.
 * Going from Y to X is very straightforward (reverse the operations by definition of the problem)
 *      If Y > X then
 *          If Y is divisible by 2 , then divide by 2
 *          If Y is not divisible by 2, the only option is to add 1
 *      If Y < X
 *          The only option is to add 1, X - Y times
 * Time complexity o(lgY) since most of the time we're dividing by 2
*/

class Solution {
    public int brokenCalc(int X, int Y) {
        int steps = 0;
        while (X != Y) {
            if (Y < X) {
                return steps + X - Y;
            }
            else {
                if (Y % 2 == 0) {
                    Y /= 2;  
                }
                else {
                    Y += 1;
                }
                steps++;
            }
        }
        return steps;
    }
}