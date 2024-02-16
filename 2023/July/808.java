/*
 * Soup Servings
 *
 * Top 88% (1ms)
 * 
 * I need to review maths. Read this one https://leetcode.com/problems/soup-servings/solutions/121711/c-java-python-when-n-4800-just-return-1/.
 * 
 * Time Complexity: O(200 * 200)
 */

class Solution {
    double[][] memo = new double[200][200];
    public double soupServings(int N) {
        /*
         * Apparently 4800 isn't the right bound, even with 5000 this works, but whatever.
         * As for the Math.ceils, a "serving" is 25 or fewer ml of soup, so we take the ceil on the total divided by 25.
         */
        return N > 5000 ?  1.0 : f((int)(Math.ceil(N / 25f)), (int)(Math.ceil(N / 25f)));
    }

    public double f(int a, int b) {
        // if they run out at the same time, its a 50% chance since with both at 0 its a coin flip which one gets taken from first apparently
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1;
        }
        if (b <= 0) {
            return 0;
        }
        if (memo[a][b] > 0) {
            return memo[a][b];
        }
        /*
         * Four options, take 4 servings of a, 3 servings of 1 and 1 of b, 2 each, or 1 serving of a and 1 serving of b
         * Clearly a is probably gonna run out first for large a,b since all options result in a losing a serving while b has a way to not 
         * lose at all.
         * 
         * The probability for a to run out with a given combination is the sum of the probabilities for each of the 25% chance options
         * (the math below just factors out the 25% from each of the four options, same result)
         */
        memo[a][b] = 0.25f * (f(a - 4, b) + f(a - 3, b - 1) + f(a - 2, b - 2) + f(a - 1, b - 3));
        return memo[a][b];
    }
}